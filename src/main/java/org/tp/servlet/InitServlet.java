package org.tp.servlet ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tp.bean.Pays;
import org.tp.commons.Const;
import org.tp.service.AdherentService;
import org.tp.service.ArticleService;
import org.tp.service.PaysService;

/**
 */
@WebServlet(urlPatterns="/init", loadOnStartup=1)
public class InitServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
    /**
	 * 
	 */
	static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
    
    //-----------------------------------------------------------------------------
    public void init() throws ServletException
    {
        System.out.println("================================================");
        System.out.println("Initialisation ...");
        System.out.println("================================================");

        ServletContext servletContext = getServletContext();
        if ( servletContext != null ) {
        	servletContext.setAttribute(Const.LISTE_PAYS, PaysService.getPays() );
        	//servletContext.setAttribute(Const.LISTE_ADHERENTS, AdherentService.getAdherents() );
        	servletContext.setAttribute(Const.LISTE_ARTICLES, ArticleService.getArticles() );
        }
        else {
        	System.out.println("ERREUR : ServletContext == NULL ! ");
        }
    }

    //-----------------------------------------------------------------------------
    //--- Requête HTTP GET
    //-----------------------------------------------------------------------------
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	process( request,  response);
    }

    //-----------------------------------------------------------------------------
    //--- Requête HTTP POST
    //-----------------------------------------------------------------------------
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	process( request,  response);
    }

    //-----------------------------------------------------------------------------
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();

        response.setContentType(CONTENT_TYPE);

        out.println("<html>");
        out.println("<h1>Liste des pays : </h1>");

        ServletContext servletContext = getServletContext();
        Object o = servletContext.getAttribute(Const.LISTE_PAYS);
        if ( o != null ) {
        	LinkedList<Pays> list = (LinkedList<Pays>) o ;
            out.println("<table>");
           	for ( Pays pays : list ) {
                out.print("<tr>");
                out.print("<td>" + pays.getCode() + "</td>" );
                out.print("<td>" + pays.getNom() + "</td>" );
                out.println("<tr>");
            }
            out.println("</table>");
        }
        else  {
            out.println("<h3>Liste non trouvée dans ServletContext ! </h3>");
        }

        out.println("<hr>");
        out.println("</html>");
    }

}