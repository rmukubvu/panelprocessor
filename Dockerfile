FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
MAINTAINER thamserios.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} panel-comms-services.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/panel-comms-services.jar"]