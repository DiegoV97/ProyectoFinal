# Build stage
FROM maven:3.8.5-openjdk-17 AS build 
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-alpine 
COPY --from=build /target/proyectoBack-0.0.1-SNAPSHOT.war /proyectoBack.war 
EXPOSE 8080
ENTRYPOINT ["java", "-war", "/proyectoBack.war"]