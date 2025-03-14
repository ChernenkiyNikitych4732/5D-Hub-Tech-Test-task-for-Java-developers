FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /target/config-server-1.0.jar /app/config-server-1.0.jar
ENTRYPOINT ["java", "-jar", "config-server-1.0.jar"]