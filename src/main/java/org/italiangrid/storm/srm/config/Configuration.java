package org.italiangrid.storm.srm.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


/**
 * Holds the service configuration. Reads a file named application.properties,
 * that must be on the classpath, and has methods for getting the service
 * configuration properties.
 * 
 * This is a singleton following Joshua Block's Effective Java recommendation that
 * 'a single-element enum type is the best way to implement a singleton'.
 * 
 * @author valerioventuri
 *
 */
public enum Configuration {

  INSTANCE;
  
  /**
   * The host on which the service will bind
   */
  private String host;
  
  /** 
   * The port to which the service will bind
   */
  private int port;
  
  /**
   * Location of the host certificate
   */
  private String hostCert;

  /**
   * Location of the host key
   */
  private String hostKey;
  
  /**
   * Location of trusted certification authorities materials
   */
  private String trustStore;
  
  /**
   * Default constructor. Here's where all the Typesafe config library magic
   * is done. This will throw a {@link RuntimeException} if something is wrong.
   * 
   */
  private Configuration() {
    
    Config config = ConfigFactory.load();
    
    // validate vs. reference.conf
    config.checkValid(ConfigFactory.defaultReference());
    
    // we want all exceptions thrown at construction time
    host = config.getString("host");
    port = config.getInt("port");
    hostCert = config.getString("hostcert");
    hostKey = config.getString("hostkey");
    trustStore = config.getString("truststore");
  }

  /**
   * @return the host
   */
  public String getHost() {
    return host;
  }

  /**
   * @return the port
   */
  public int getPort() {
    return port;
  }

  /**
   * @return the hostcert
   */
  public String getHostCert() {
    return hostCert;
  }

  /**
   * @return the hostkey
   */
  public String getHostKey() {
    return hostKey;
  }

  /**
   * @return the truststore
   */
  public String getTrustStore() {
    return trustStore;
  }
  
}
