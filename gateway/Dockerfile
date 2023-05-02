FROM openjdk:17


# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file and configuration files to the container
COPY target/gateway-0.0.1-SNAPSHOT.jar /app/myapp.jar
COPY src/main/resources/application.properties /app/application.properties
COPY src/main/resources/application.yml /app/application.yml

# Expose port 8080 to the host
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "/app/myapp.jar"]
