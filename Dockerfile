# Run stage
FROM openjdk:17-alpine 
COPY --from=build /home/app/target/proyectoBack-0.0.1-SNAPSHOT.war  /usr/share/app.war 
ENTRYPOINT ["java", "-jar", "/usr/share/app.war"]