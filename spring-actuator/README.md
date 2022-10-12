# Spring-Actuator

- reference : https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator
- git : https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-actuator


## Metrics

- git : https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.metrics
- reference 
    - https://docs.spring.io/spring-metrics/docs/current/public/atlas
    - https://docs.spring.io/spring-boot/docs/1.1.1.RELEASE/reference/html/production-ready-metrics.html


### MVC

- Spring MVC Metrics
~~~
management.metrics.web.server.request.autotime.enabled
~~~

### WebFlux
- Spring WebFlux Metrics
~~~
management.metrics.web.server.request.autotime.enabled
~~~


### Spring Data Repository Metrics
~~~
management.metrics.data.repository.autotime.enable
~~~


### Custom Metrics

- error-rate : https://reflectoring.io/monitoring-error-rate-spring-boot/


## micrometer-registry-prometheus

- git : https://github.com/micrometer-metrics/micrometer/tree/main/implementations/micrometer-registry-prometheus

~~~
    GET /actuator/prometheus
~~~


## logstash-logback-encoder

- git : https://github.com/logstash/logstash-logback-encoder


### Getting Started Spring Boot Actuator

- https://www.baeldung.com/spring-boot-actuators
