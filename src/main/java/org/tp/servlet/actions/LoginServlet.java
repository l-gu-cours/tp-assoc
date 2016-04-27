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
@WebServlet(urlPatterns="/login")
public class LoginServlet extends GenericActionServlet
{
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		setLoginRequired(false);
	}

	//-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	//String sPage = "/Login.jsp" ;
    	String sPage = Page.LOGIN ;
    	
    	String sIdent = request.getParameter("ident");
    	String sMotPasse = request.getParameter("motpasse");
    	if ( sIdent != null && sMotPasse != null )
    	{
    		if ( sMotPasse.equalsIgnoreCase("ok"))
    		{
    			sPage = Page.WELCOME ;
    			HttpSession session = request.getSession();
    			session.setAttribute(Const.ADHERENT, sIdent);
    		}
    	}
    	
		forward(request, response, sPage);
    }

}