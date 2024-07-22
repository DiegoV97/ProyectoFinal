FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
EXPOSE 8080
COPY --from=build /app/target/proyectoBack-0.0.1-SNAPSHOT.war /app/proyectoBack-0.0.1-SNAPSHOT.war
CMD ["java", "-jar", "/app/proyectoBack-0.0.1-SNAPSHOT.war"]
