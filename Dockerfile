FROM maven:3.8.3-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /target/proyectoBack-0.0.1-SNAPSHOT.war app.war
CMD ["java", "-jar", "app.war"]
