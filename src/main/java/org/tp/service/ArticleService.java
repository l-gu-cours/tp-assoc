package org.tp.service;

import java.security.InvalidParameterException;
import java.util.LinkedList;

import org.tp.bean.Article;

public class ArticleService {

	private final static LinkedList<Article> list = new LinkedList<Article>();
	
	static {
		list.add(new Article("T1","Tee Shirt", 12, 55.60) );
		list.add(new Article("C2","Cle USB", 45, 9.50 ) );
		list.add(new Article("S3","Stylo", 34, 3.70 ) );
		list.add(new Article("C4","Calculatrice", 4, 20.00 ) );
	}
	
	public final static LinkedList<Article> getArticles() {
		return list ;
	}

	public final static Article findArticle ( String id ) {
		if ( id == null ) {
			throw new InvalidParameterException("'id' parameter is null");
		}
		
		for ( Article a : list ) {
			if ( a != null ) {
				if ( a.getCode().equalsIgnoreCase(id) ) {
					return a ;
				}
			}
		}
		return null ;
	}

}
