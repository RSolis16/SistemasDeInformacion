# Etapa 1: Build del proyecto usando Maven Wrapper
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copiamos todos los archivos del proyecto
COPY . .

# Damos permisos por si el wrapper no tiene permisos
RUN chmod +x mvnw

# Compilamos la app
RUN ./mvnw clean package -DskipTests


# Etapa 2: Imagen final ligera para ejecutar la app
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar construido
COPY --from=build /app/target/*.jar app.jar

# Puerto (Render lo ignora pero ayuda)
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
