FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /target/gateway-service-1.0.jar /app/gateway-service-1.0.jar
ENTRYPOINT ["java", "-jar", "gateway-service-1.0.jar"]