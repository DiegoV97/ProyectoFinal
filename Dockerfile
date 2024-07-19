# Run stage
FROM openjdk:17-alpine-jdk 
COPY /target/proyectoBack-0.0.1-SNAPSHOT.war /app.war 
ENTRYPOINT ["java", "-war", "/app.war"]