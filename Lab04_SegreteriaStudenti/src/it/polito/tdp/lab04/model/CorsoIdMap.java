package it.polito.tdp.lab04.model;

import java.util.HashMap;
import java.util.Map;

public class CorsoIdMap {

private Map<String, Corso> map;
	
	public CorsoIdMap() {
		map = new HashMap<>();
	}
	
	public Corso get(Corso corso) {
		Corso old = map.get(corso.getCodins());
		if(old == null) {
			//La mappa non contiene questo studente
			map.put(corso.getCodins(), corso);
			return corso;
		}
		return old;
	}
	
	public void put(String codins, Corso corso) {
		map.put(codins, corso);
	}

	public Corso get(String codins) {
		return map.get(codins);
	}
}
