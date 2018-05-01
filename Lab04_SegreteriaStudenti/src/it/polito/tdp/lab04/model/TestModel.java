package it.polito.tdp.lab04.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		int matricola = 146101;
		int result = model.getTotCreditiFromStudente(matricola);
		System.out.println("Tot crediti: "+ result);

		
		List<Studente> res = model.getStudentiFromCorso("01NBAPG");
		for(Studente s : res)
			System.out.println(s);
		
		List<Corso> rescorsi = model.getCorsiFromStudente(146101);
		for(Corso c : rescorsi)
			System.out.println(c);
	}

}
