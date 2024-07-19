# Run stage
FROM openjdk:17-alpine 
COPY --from=build /target/proyectoBack-0.0.1-SNAPSHOT.war  /app.war 
ENTRYPOINT ["java", "-jar", "/usr/share/app.war"]