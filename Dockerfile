FROM openjdk:16-jdk-alpine
COPY target/*.jar mongoJava.jar
ENTRYPOINT ["java", "-jar", "/mongoJava.jar"]