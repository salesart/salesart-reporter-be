FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/salesart-reporter-1.0.0.jar
COPY ${JAR_FILE} application.jar