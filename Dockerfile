FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim

# Copy the jar to the production image from the builder stage.
COPY --from=builder /app/target/fib-boot-func*.jar /fib-boot-func.jar

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/fib-boot-func.jar"]