FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /target/discovery-server-1.0.jar /app/discovery-server-1.0.jar
ENTRYPOINT ["java", "-jar", "discovery-server-1.0.jar"]