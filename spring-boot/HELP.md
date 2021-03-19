# Hot to run
* `docker build -t dma1979/gs-spring-boot-docker .` to build the container
* `docker run -p 8100:8100 -d --name boot-greetings dma1979/gs-spring-boot-docker` to run the container
* open `http://localhost:8100/hello` or  run `curl http://localhost:8100/hello` or 'http :8100/hello' to check
* `docker container rm -f  <CONTAINER_ID>` to force stop/remove
* `jar tf target/greeting-0.0.1-SNAPSHOT.jar` to inspect the jar file.
* `java -Djarmode=layertools -jar target/greeting-0.0.1-SNAPSHOT.jar list` to list the layers inside the artifact.
* `java -Djarmode=layertools -jar target/greeting-0.0.1-SNAPSHOT.jar  extract` to extract the layers into folders.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#production-ready)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

