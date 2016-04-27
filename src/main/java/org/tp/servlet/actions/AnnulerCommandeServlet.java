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
@WebServlet(urlPatterns="/annulerCommande")
public class AnnulerCommandeServlet extends GenericActionServlet
{
	static final long serialVersionUID = 1L;

    //-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
		session.removeAttribute(Const.COMMANDE );
    	
		forward(request, response, Page.WELCOME);
    }

}