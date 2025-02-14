# Imagen base con Java 8
FROM amazoncorretto:8

# Configurar directorio de trabajo en la imagen
WORKDIR /app

# Copiar el archivo JAR generado en la carpeta target/
COPY target/back-group-6-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
