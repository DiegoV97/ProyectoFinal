# Build stage
FROM maven:3.8.3-openjdk-17 AS build 
COPY src /home/app/src 
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml 

# Run stage
FROM openjdk:17-alpine 
COPY /target/Spa-0.0.1-SNAPSHOT.war /app.war 
ENTRYPOINT ["java", "-jar", "/app.war"]