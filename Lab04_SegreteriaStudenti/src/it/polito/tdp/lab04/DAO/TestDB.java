package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.CorsoIdMap;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		CorsoIdMap corsomap = new CorsoIdMap();
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi(corsomap);

	}

}
