FROM maven:3.8.2-jdk-11 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-buster
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
