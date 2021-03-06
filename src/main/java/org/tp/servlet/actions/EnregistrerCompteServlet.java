package org.tp.servlet.actions ;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tp.commons.Page;
import org.tp.servlet.GenericActionServlet;

/**
 */
@WebServlet(urlPatterns="/enregistrerCompte")
public class EnregistrerCompteServlet extends GenericActionServlet
{
	static final long serialVersionUID = 1L;
    
	public EnregistrerCompteServlet() {
		super();
		setLoginRequired(false);
	}
	
    //-----------------------------------------------------------------------------
    protected List<String> checkRequiredParameters(HttpServletRequest request, String...paramNames) throws ServletException, IOException
    {
    	List<String> missingParameters = new LinkedList<>();
    	for ( String name : paramNames ) {
    		String v = request.getParameter(name) ;
        	trace(" parameter '" + name + "' = '" + v + "'" ); 
    		if ( v == null ) {
    			missingParameters.add(name);
    		}
    		else if ( v.trim().length() == 0 ) {
    			missingParameters.add(name);
    		}
    	}
    	return missingParameters ;
    }

    //-----------------------------------------------------------------------------
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	List<String> missingParameters = checkRequiredParameters(request, "ident", "mp1","mp2", "nom", "prenom");
    	trace("missing parameter(s) : " + missingParameters.size() ); 
    	if ( missingParameters.size() > 0 ) {
    		forward(request, response, Page.FORM_COMPTE );
    	}
    	else {
    		forward(request, response, Page.WELCOME );
    	}
    }

}