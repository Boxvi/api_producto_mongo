FROM maven:3.9.3-sapmachine-17 AS compile
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY --from=compile /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
