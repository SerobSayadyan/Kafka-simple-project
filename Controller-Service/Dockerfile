# Use a lightweight JRE image
FROM eclipse-temurin:21-jre-jammy AS final

WORKDIR /app

# Copy the locally built JAR file into the Docker image
COPY target/*.jar app.jar

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
