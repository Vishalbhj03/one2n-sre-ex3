# Stage 1: Build JAR
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only pom.xml first (better caching)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copy entire source
COPY src ./src

# Build the Spring Boot application
RUN mvn -q -DskipTests package


# Stage 2: Runtime Image
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

USER appuser

# Environment variables (can be overridden at runtime)
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod

# Copy jar from builder stage
COPY --from=build /app/target/*.jar app.jar

# App runs on port 8087
EXPOSE 8087

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
