#LEGACY multistage
#stage 1
#FROM maven:3.6-jdk-11 as BUILD

#ADD repository.tar.gz /usr/share/maven/ref/

#COPY . /usr/src/app
#WORKDIR /usr/src/app
#RUN mvn -s /usr/share/maven/ref/settings-docker.xml package

#stage 2
#FROM openjdk:11-jre
#EXPOSE 8100 5005
#COPY --from=BUILD /usr/src/app/target /opt/target
#WORKDIR /opt/target
#ENV _JAVA_OPTIONS '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'

#CMD ["java", "-jar", "greeting.war"]

# `docker build -t dma1979/gs-spring-boot-docker .`
# `docker run -p 8100:8100 -d --name boot-greetings dma1979/gs-spring-boot-docker`
#FROM openjdk:11.0.10-jdk-slim
#RUN addgroup --system spring && adduser --system spring --ingroup spring
#USER spring:spring
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


# MULTISTAGE
# syntax=docker/dockerfile:experimental
FROM openjdk:11.0.10-jdk-slim as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11.0.10-jdk-slim
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","by.dma.demo.DemoApplication"]

