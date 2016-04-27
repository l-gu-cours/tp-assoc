package org.tp.servlet.actions ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tp.commons.Page;
import org.tp.servlet.GenericActionServlet;

/**
 */
@WebServlet(urlPatterns="/logout")
public class LogoutServlet extends GenericActionServlet
{
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		HttpSession session = request.getSession(false);
		if ( session != null ) {
			//session.removeAttribute(Const.ADHERENT);
			session.invalidate(); // Tout est supprimé (login, commande, etc )
		}
    	
		forward(request, response, Page.LOGIN );
    }

}