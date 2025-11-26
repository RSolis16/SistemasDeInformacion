# Etapa 1: Build con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos POM y SRC desde la ruta real
COPY "Proyecto SI/BACK/Proyecto/pom.xml" ./pom.xml
COPY "Proyecto SI/BACK/Proyecto/src" ./src

# Construimos sin tests
RUN mvn -e -X -DskipTests package

# Etapa 2: Runtime con JDK
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiamos el JAR generado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
