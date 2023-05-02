# Use the official OpenJDK 17 image as the base image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the executable jar file and other necessary files from the host to the container
COPY target/demo-0.0.1-SNAPSHOT.jar /app/my-eureka-server.jar
COPY /src/main/resources/application.properties /app/application.properties

# Expose port 8080 for the Spring application
EXPOSE 8761

# Set the command to run the Spring application
CMD ["java", "-jar", "/app/my-eureka-server.jar"]