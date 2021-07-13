# Spring-Actuator

- reference : https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator
- git : https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-actuator


## Metrics

git : https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.metrics

### MVC

- Spring MVC Metrics
~~~
management.metrics.web.server.request.autotime.enabled
~~~

- Spring WebFlux Metrics
~~~
management.metrics.web.server.request.autotime.enabled
~~~




### micrometer-registry-prometheus

- git : https://github.com/micrometer-metrics/micrometer/tree/main/implementations/micrometer-registry-prometheus

~~~
GET /actuator/prometheus
~~~

