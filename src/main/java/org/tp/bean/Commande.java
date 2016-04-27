package org.tp.bean;

import java.util.LinkedList;

public class Commande {

	LinkedList<Article> listCommande = new LinkedList<Article>();
	
	//LinkedList listCatalogue = null ;
	
	
//	public Commande(LinkedList listCatalogue) {
//		super();
//		//this.listCatalogue = listCatalogue;
//	}

	public void commanderArticle(Article a )
	{
		listCommande.add(a);
		System.out.println("Article commandé : " + a.getCode() + " : " + a.getNom() );
	}

	public int getNbArticles()
	{
		return listCommande.size();
	}
	
	public LinkedList<Article> getListe()
	{
		return listCommande ;
	}
}
