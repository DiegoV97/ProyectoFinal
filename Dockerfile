# Build stage
FROM maven:3.8.5-openjdk-17 AS build 
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./mvnw spring-boot:run

# Run stage
FROM openjdk:17-slim
COPY --from=build /target/*.war /app.war
EXPOSE 8080
CMD ["java", "-jar", "/app.war"]