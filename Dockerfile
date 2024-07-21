# Build stage
FROM maven:3.8.5-openjdk-17 AS build 
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-slim
COPY --from=build /target/*.war /app.war
EXPOSE 8080
CMD ["java", "-jar", "/app.war"]
