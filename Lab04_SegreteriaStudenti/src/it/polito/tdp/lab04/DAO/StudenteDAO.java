package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.lab04.model.*;

public class StudenteDAO {

	public List<Studente> getTuttiStudenti(StudenteIdMap studentimap)
	{

		String sql = "SELECT matricola, nome, cognome, cds FROM studente";

		List<Studente> result = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Studente s = new Studente(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"),
						res.getString("cds"));
				result.add(studentimap.get(s));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
		
	}
	
	
	public void getStudentiFromCorso(Corso c, StudenteIdMap studentemap) {
		
		String sql = "SELECT s.matricola, s.nome, s.cognome, s.cds FROM studente AS s, iscrizione AS i WHERE s.matricola = i.matricola AND i.codins= ?";
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getCodins());
			
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Studente s = new Studente(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"),
						res.getString("cds"));
				c.getStudenti().add(studentemap.get(s));  //non direttamente l'oggetto, ma il riferimento restituito da StudenteIdMap
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	public boolean iscriviStudenteACorso(Studente studente, Corso corso) {

		String sql = "INSERT IGNORE INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`) VALUES(?,?)";
		boolean returnValue = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			st.setString(2, corso.getCodins());
			
			int res = st.executeUpdate();	

			if (res == 1)
				returnValue = true;

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return returnValue;
	}

}
