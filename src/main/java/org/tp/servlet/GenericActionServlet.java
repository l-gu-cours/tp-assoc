package org.tp.servlet ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tp.commons.Const;
import org.tp.commons.Page;

/**
 */
public abstract class GenericActionServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet 
{
	private static final long serialVersionUID = 1L;
	
	private boolean loginRequired = true ;

	protected abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;

    //-----------------------------------------------------------------------------
    protected void setLoginRequired(boolean b) {
    	this.loginRequired = b ;
    }

    //-----------------------------------------------------------------------------
    protected void trace(String msg) {
    	System.out.println("[TRACE] " +this.getClass().getSimpleName() + " : " + msg);
    }

    //-----------------------------------------------------------------------------
    protected void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException
    {
    	trace("forward to '" + page + "'");
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
    }

    //-----------------------------------------------------------------------------
    //--- Requête HTTP GET
    //-----------------------------------------------------------------------------
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	processAction( request,  response);
    }

    //-----------------------------------------------------------------------------
    //--- Requête HTTP POST
    //-----------------------------------------------------------------------------
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	processAction( request,  response);
    }

    //-----------------------------------------------------------------------------
    private boolean isLogin(HttpServletRequest request) //throws ServletException, IOException
    {
    	boolean r = false ;
    	// Si adherent déjà en session 
		HttpSession session = request.getSession(false);
		if ( session != null ) {
			if ( session.getAttribute(Const.ADHERENT) != null ) {
		    	r = true ;
			}
		}
    	trace("is login ? " + r);
		return r ;
    }

    //-----------------------------------------------------------------------------
    private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	trace("process action : URI = " + request.getRequestURI());
    	if ( isLogin(request) == false && this.loginRequired == true ) {
    		forward(request, response, Page.LOGIN );
    	}
    	else {
        	process(request, response);
    	}
    }


}