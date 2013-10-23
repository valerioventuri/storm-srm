package org.italiangrid.storm.srm.server;

import org.apache.axis.transport.http.AxisServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.italiangrid.storm.srm.config.Configuration;
import org.italiangrid.utils.https.SSLOptions;
import org.italiangrid.utils.https.ServerFactory;
import org.italiangrid.utils.voms.VOMSSecurityContextHandler;



/**
 * The main class.
 * 
 * @author valerioventuri
 *
 */
public class Main {

	/**
	 * The Jetty Server.
	 */
	private static Server server;

	/**
	 * @param args
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		configureServer();
		configureHandlers();
		server.start();
		
	}

	/**
	 * Configure the Jetty Server.
	 * 
	 */
	private static void configureServer() {

		SSLOptions sslOptions = new SSLOptions();
		sslOptions.setCertificateFile(Configuration.INSTANCE.getHostCert());
		sslOptions.setKeyFile(Configuration.INSTANCE.getHostKey());
		sslOptions.setTrustStoreDirectory(Configuration.INSTANCE.getTrustStore());
		sslOptions.setTrustStoreRefreshIntervalInMsec(600000L);
		sslOptions.setNeedClientAuth(true);

		server = ServerFactory.newServer(Configuration.INSTANCE.getHost(),
			Configuration.INSTANCE.getPort(), sslOptions);

	}

	/**
	 * Configure handlers for the Jetty Server.
	 */
	private static void configureHandlers() {

		HandlerList handlers = new HandlerList();
		server.setHandler(handlers);

		// needed to get rid of the '0' that clientSRM sends in front of the method

		Handler zeroHandler = new ZeroHandler();
		handlers.addHandler(zeroHandler);

		// voms handler
		
		 handlers.addHandler(new VOMSSecurityContextHandler());
		
		// the axis servlet for the srm service

		AxisServlet axisServlet = new AxisServlet();

		ServletHolder axisServletHolder = new ServletHolder(axisServlet);

		ServletContextHandler axisServletContextHandler = new ServletContextHandler(
			ServletContextHandler.SESSIONS);
		axisServletContextHandler.addServlet(axisServletHolder, "/*");

		handlers.addHandler(axisServletContextHandler);

	}

}
