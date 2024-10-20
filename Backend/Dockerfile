# Usa una imagen base de OpenJDK 17
FROM openjdk:17-slim


# Especifica el autor del Dockerfile
LABEL authors="patrik"

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en el directorio actual a la carpeta del contenedor
COPY target/CasoPractico2-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/biological_data.csv /app/biological_data.csv

# Expone el puerto en el que correrá la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java", "-jar", "app.jar"]
