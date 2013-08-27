package org.italiangrid.storm.srm.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


/**
 * This handler modifies incoming requests in case the method string is
 * '0POST' setting it to 'POST'.
 * 
 * This is an hack  needed to make the service work with clientSRM, which 
 * sends requests with a '0POST' method.
 * 
 * @author valerioventuri
 *
 */
public class ZeroHandler extends AbstractHandler {

	/**
	 * Check whether the method string for the incoming request 
	 * is '0POST'. If it is '0POST' it changed it to 'POST', otherwise
	 * it does nothing.
	 * 
	 */
	public void handle(String target, Request baseRequest,
		HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		String method = baseRequest.getMethod();
		
		if(method.equals("0POST")) {

			baseRequest.setMethod("POST");
		
		}
	
	}

}
