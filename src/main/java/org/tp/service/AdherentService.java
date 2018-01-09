package org.tp.service;

import java.util.LinkedList;

import org.tp.bean.Adherent;

public class AdherentService {

	private final static LinkedList<Adherent> list = new LinkedList<Adherent>();
	
	static {
		list.add(new Adherent("Zola","Emile", "2 rue de Plantes", 44000, "Nantes", "FR" ) );
		list.add(new Adherent("Flaubert","Gustave", "23 Bd Foch", 35000, "Rennes", "FR" ) );
	}
	
	public final static LinkedList<Adherent> getAdherents() {
		return list ;
	}

}
