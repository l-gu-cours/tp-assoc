package org.tp.bean;

import java.security.InvalidParameterException;
import java.util.LinkedList;

public class Commande {

	private final LinkedList<LigneCommande> lignes = new LinkedList<LigneCommande>();
	
	public void commanderArticle(Article article) {
		if ( article == null ) {
			throw new InvalidParameterException("'article' parameter is null");
		}
		if ( article.getStock() > 0 ) {
			article.decrementStock();
			LigneCommande ligne = getLigneCommande(article.getCode());
			if ( ligne != null ) {
				ligne.increment();
				System.out.println("Commande : +1 article " + article.getCode() + " : " + article.getNom() );
			}
			else {
				lignes.add(new LigneCommande(article, 1));
				System.out.println("Commande : new article " + article.getCode() + " : " + article.getNom() );
			}
		}
	}
	
	public void annuler() {
		// Restore stock
		for ( LigneCommande ligne : lignes ) {
			Article article = ligne.getArticle();
			article.incrementStock(ligne.getNombre());
		}
		// Remove all lines
		lignes.clear();
	}
	
	public int getNbArticles() {
		return lignes.size();
	}

	public double getPrixTotal() {
		double prix = 0.0 ;
		for ( LigneCommande ligne : lignes ) {
			prix = prix + ligne.getPrixTotal();
		}
		return prix ;
	}
	
	public LinkedList<LigneCommande> getLignes() {
		return lignes ;
	}

	public LigneCommande getLigneCommande(String code) {
		if ( code == null ) {
			throw new InvalidParameterException("'code' parameter is null");
		}
		for ( LigneCommande ligne : lignes ) {
			if ( ligne != null ) {
				if ( ligne.getCode().equalsIgnoreCase(code) ) {
					return ligne ;
				}
			}
		}
		return null ;
	}
}
