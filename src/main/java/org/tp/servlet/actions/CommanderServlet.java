package org.tp.servlet.actions ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tp.bean.Article;
import org.tp.bean.Commande;
import org.tp.commons.Const;
import org.tp.commons.Page;
import org.tp.service.ArticleService;
import org.tp.servlet.GenericActionServlet;

/**
 */
@WebServlet(urlPatterns="/commander")
public class CommanderServlet extends GenericActionServlet
{
	static final long serialVersionUID = 1L;

    //-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    	String sIdArticle = request.getParameter("id");
    	if ( sIdArticle != null ) {
        	System.out.println("Id article = " + sIdArticle );
        	Article article = ArticleService.findArticle(sIdArticle);
    		if ( article != null ) {
                HttpSession session = request.getSession();
    			Object o = session.getAttribute(Const.COMMANDE);
    	    	if ( o != null ) {
                	System.out.println("Commande trouvée en session");
    	    		Commande c = (Commande) o;
    	    		c.commanderArticle(article);
    	    	}
    	    	else {
                	System.out.println("Création commande");
    	    		Commande c = new Commande();
    	    		c.commanderArticle(article);
    	    		session.setAttribute(Const.COMMANDE, c);
    	    	}
    		}
    		else {
            	System.out.println("Article " + sIdArticle + " inexistant !");
    		}
    	}
    	
		forward(request, response, Page.ARTICLES);
    }

}