FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /target/user-service-1.0.jar /app/user-service-1.0.jar
ENTRYPOINT ["java", "-jar", "user-service-1.0.jar"]