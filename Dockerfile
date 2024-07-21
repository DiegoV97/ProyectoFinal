FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
#FROM openjdk:17-jdk-slim
FROM openjdk:17-alpine 
WORKDIR /app
COPY --from=build /app/target/proyectoBack-0.0.1-SNAPSHOT.war app.war
CMD ["java", "-jar", "app.war"]
