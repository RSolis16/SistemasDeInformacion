# Etapa 1: Build con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Como el Dockerfile está junto a pom.xml y src, NO usamos rutas
COPY pom.xml .
COPY src ./src

RUN mvn -e -X -DskipTests package

# Etapa 2: Runtime
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
