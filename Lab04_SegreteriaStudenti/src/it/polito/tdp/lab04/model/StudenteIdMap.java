package it.polito.tdp.lab04.model;

import java.util.*;

public class StudenteIdMap {

	private Map<Integer, Studente> map;
	
	public StudenteIdMap() {
		map = new HashMap<>();
	}
	
	public Studente get(Studente studente) {
		Studente old = map.get(studente.getMatricola());
		if(old == null) {
			//La mappa non contiene questo studente
			map.put(studente.getMatricola(), studente);
			return studente;
		}
		return old;
	}
	
	public void put(int matricola, Studente studente) {
		map.put(matricola, studente);
	}

	public Studente get(int matricola) {
		return map.get(matricola);
	}
}
