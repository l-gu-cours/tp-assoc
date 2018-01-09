package org.tp.bean;

public class LigneCommande {

	private Article article ;
	private int nombre ;
	
	public LigneCommande(Article article, int nombre) {
		super();
		if ( article == null ) {
			throw new IllegalArgumentException("Article is null");
		}
		if ( nombre <= 0 ) {
			throw new IllegalArgumentException("Nombre <= 0 ");
		}
		this.article = article;
		this.nombre = nombre;
	}

	public Article getArticle() {
		return article;
	}

	public String getCode() {
		return article.getCode();
	}
	public String getNom() {
		return article.getNom();
	}
	public double getPrixUnitaire() {
		return article.getPrix();
	}
	public double getPrixTotal() {
		return article.getPrix() * nombre ;
	}

	public int getNombre() {
		return nombre;
	}

	public void increment() {
		nombre++;
	}
	
}
