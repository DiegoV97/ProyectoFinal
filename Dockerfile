# Build stage
FROM maven:3.8.3-openjdk-17 AS build 
COPY src /app/src 
COPY pom.xml /app
RUN mvn -f /app/pom.xml 

# Run stage
FROM openjdk:17-alpine 
COPY --from=build /target/proyectoBack-0.0.1-SNAPSHOT.war /app.war 
ENTRYPOINT ["java", "-jar", "/app.war"]