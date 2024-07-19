# Run stage
FROM openjdk:17-alpine
COPY /target/proyectoBack-0.0.1-SNAPSHOT.war /app.war 
ENTRYPOINT ["java", "-jar", "/app.war"]