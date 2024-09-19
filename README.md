# Spring Cloud Config Client
###
This repo is testing for spring cloud configuration 

Dependency
```

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

Client Configuration
```
server:
  port: 8081
spring:
  application:
    name: spring-cloud-config-client
  profiles:
    active: dev
  config:
    import: optional:configserver:http://localhost:8888?fail-fast=true&max-attempts=10&max-interval=1500&multiplier=1.2&initial-interval=1100

#need to refresh for config client after updating on config data
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

Manual refresh endponit for client
```
# curl --location --request POST 'http://[client-url]/actuator/refresh'
```
