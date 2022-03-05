# Tomcat

## mbeanregistry

~~~yml
server:
  tomcat:
    mbeanregistry:
      enabled: true
~~~

### TomcatServletWebServerFactoryCustomizer

~~~java
factory.setDisableMBeanRegistry(!tomcatProperties.getMbeanregistry().isEnabled());
~~~

### TomcatServletWebServerFactory

~~~java
private boolean disableMBeanRegistry = true;
~~~

~~~java
    @Override
	public WebServer getWebServer(ServletContextInitializer... initializers) {
		if (this.disableMBeanRegistry) {
			Registry.disableRegistry();
		}
		Tomcat tomcat = new Tomcat();
		File baseDir = (this.baseDirectory != null) ? this.baseDirectory : createTempDir("tomcat");
		tomcat.setBaseDir(baseDir.getAbsolutePath());
		Connector connector = new Connector(this.protocol);
		connector.setThrowOnFailure(true);
		tomcat.getService().addConnector(connector);
		customizeConnector(connector);
		tomcat.setConnector(connector);
		tomcat.getHost().setAutoDeploy(false);
		configureEngine(tomcat.getEngine());
		for (Connector additionalConnector : this.additionalTomcatConnectors) {
			tomcat.getService().addConnector(additionalConnector);
		}
		prepareContext(tomcat.getHost(), initializers);
		return getTomcatWebServer(tomcat);
	}
~~~



