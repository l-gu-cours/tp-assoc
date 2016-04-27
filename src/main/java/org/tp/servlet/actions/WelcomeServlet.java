package org.tp.servlet.actions ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tp.commons.Const;
import org.tp.commons.Page;
import org.tp.servlet.GenericActionServlet;

/**
 */
@WebServlet(urlPatterns="/welcome")
public class WelcomeServlet extends GenericActionServlet
{
	static final long serialVersionUID = 1L;
	
    //-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String sPage = Page.LOGIN ;
    	
    	// Si adherent déjà en session 
		HttpSession session = request.getSession(false);
		if ( session != null ) {
			if ( session.getAttribute(Const.ADHERENT) != null ) {
		    	sPage = Page.WELCOME ;
			}
		}

		forward(request, response, sPage);
    }

}