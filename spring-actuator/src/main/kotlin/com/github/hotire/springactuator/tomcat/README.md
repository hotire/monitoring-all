# Tomcat


## mbeanregistry

~~~yml
server:
  tomcat:
    mbeanregistry:
      enabled: true
~~~

### MBeanserver

MBeans는 Managed Beans의 약어다.
 - jmx기술을 이용하여 J2EE 서버의 상태롤 조정,제어할수 있도록 해주는 JavaBean 오브젝트란다.
그럼 jmx 는 멀까?
 - JMX(Java Management Extension)는 J2EE 스펙에서 제공하는 J2EE 컨테이너 관리 도구이다.
이러한 MBeans는 관리 에이전트로써 동작하고 자바 프로그래밍 언어에 대해 가능한 대부분의 디바이스 상에서 실행될수 있는 MBean 서버라고 불리는 핵심 관리 오브젝트 서버에서 등록 된다.

- Manageable Resource : 관리대상의 되는 리소스
- MBean : Managed bean의 약자이며, 플랫폼 혹은 사용자에 의해 만들어진 모니터링용 객체, Manageble Resource에 대한 접근 및 조작에 대한 interface를 제공한다.
- MBean Server : MBean을 관리하는 Java Class
- JMX Agent : Mbean 관리를 위한 서비스를 제공하는 Java Process. 다양한 Protocol Adapter와 Connector를 제공한다.
- Management Application : JMX 활용하여 만들어진 Application 관리를 담당하는 Application
- Notification : MBean에 의해 발생한 event, alert, information을 Wrapping한 Java Object
- Instrumentation : MBean에 의해 관리되는 리소스들



- https://interwater.tistory.com/entry/Bootstrapjava-%EC%97%90%EC%84%9C-MbeanServer-%EB%9E%80
- https://narup.tistory.com/23
- https://jg-seo.tistory.com/27


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

### Repository
~~~java
 public static synchronized void disableRegistry() {
        if (registry == null) {
            registry = new NoDescriptorRegistry();
        } else if (!(registry instanceof NoDescriptorRegistry)) {
            log.warn(sm.getString("registry.noDisable"));
        }
    }
~~~

### TomcatMetrics

~~~java
   public static MBeanServer getMBeanServer() {
        List<MBeanServer> mBeanServers = MBeanServerFactory.findMBeanServer(null);
        if (!mBeanServers.isEmpty()) {
            return mBeanServers.get(0);
        }
        return ManagementFactory.getPlatformMBeanServer();
    }

~~~


