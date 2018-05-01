package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.*;

public class Model {

	private CorsoDAO cdao;
	private StudenteDAO sdao;
	
	private List<Corso> corsi;
	private List<Studente> studenti;
	
	private CorsoIdMap corsomap;
	private StudenteIdMap studentemap;
	
	public Model() {
		cdao = new CorsoDAO();
		sdao = new StudenteDAO();
		
		corsomap = new CorsoIdMap();
		studentemap = new StudenteIdMap();
		
		corsi = cdao.getTuttiICorsi(corsomap);
		studenti = sdao.getTuttiStudenti(studentemap);
		
		for(Studente s : studenti)
			cdao.getCorsiFromStudente(s, corsomap);
		
		for(Corso c : corsi)
			sdao.getStudentiFromCorso(c, studentemap);
	}
	
	
	public int getTotCreditiFromStudente(int matricola) {
		
		int sum = 0;
		
		for(Studente s : studenti) {
			if(s.getMatricola() == matricola) {
				for(Corso c : s.getCorsi()) 
					sum += c.getNumeroCrediti();
				return sum;
			}
		}
		
		return -1;
	}
	
	//punto 3, tramite pattern ORM è banale
	public List<Studente> getStudentiFromCorso(String codins){
		
		Corso c = corsomap.get(codins);
		
		if(c == null)
			return new ArrayList<Studente>();
		
		return c.getStudenti();
	}
	
	//punto 4, con pattern ORM
	public List<Corso> getCorsiFromStudente(int matricola){
		
		Studente s = studentemap.get(matricola);
		
		if(s == null)
			return new ArrayList<Corso>();
		
		return s.getCorsi();
	}
	
	public boolean iscriviStudenteACorso(int matricola, String codins) {
		//Aggiorna info nel DB e poi aggiorno riferimenti in memoria
		
		Corso corso = corsomap.get(codins);
		Studente studente = studentemap.get(matricola);
		
		
		if(studente == null || corso== null)
			return false;                               //non posso iscrivere uno studente a un corso
	
		boolean result = sdao.iscriviStudenteACorso(studente, corso);
		if(result==true) {          //aggiornamento effettuato con successo
			
			//aggiorno i riferimenti in memoria
			if(!studente.getCorsi().contains(corso)) {       //perchè le liste accettano duplicati
			studente.getCorsi().add(corso);
			}
			if(!corso.getStudenti().contains(studente)) {
			corso.getStudenti().add(studente);
			}
			
			return true;
		}
		return false;
	}
	
}
