package org.tp.servlet.actions ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tp.commons.Page;
import org.tp.servlet.GenericActionServlet;

/**
 */
@WebServlet(urlPatterns="/creerCompte")
public class CreerCompteServlet extends GenericActionServlet
{
	static final long serialVersionUID = 1L;
    
	public CreerCompteServlet() {
		super();
		setLoginRequired(false);
	}

    //-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		forward(request, response, Page.FORM_COMPTE );
    }

}