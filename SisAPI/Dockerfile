#{"id":"58291","variant":"standard","title":"Dockerfile para Spring Boot con Maven (Render)"}
# Etapa 1: Construcción
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copiar el proyecto completo
COPY . .

# Dar permisos y construir
RUN chmod +x mvnw
RUN ./mvnw -DskipTests clean package

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el jar compilado desde target/
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
