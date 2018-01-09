package org.tp.service;

import java.util.LinkedList;

import org.tp.bean.Pays;

public class PaysService {

	private static final LinkedList<Pays> list = new LinkedList<Pays>();
	
	static {
		list.add(new Pays("FR","France") );
		list.add(new Pays("ES","Espagne") );
		list.add(new Pays("IT","Italie") );
		list.add(new Pays("BE","Belgique") );
		list.add(new Pays("CA","Canada") );
	}
	
	public final static LinkedList<Pays> getPays() {
		return list ;
	}

}
