# Se obtiene desde una imagen de Java 17 con Alpine (más ligera)
FROM eclipse-temurin:17-jdk

# Se establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Se establece el directorio donde se montará la wallet de Oracle dentro del contenedor
ENV ORACLE_WALLET_DIR=/app/Wallet_tienda

# Copia el wallet al contenedor
COPY Wallet_tienda/ $ORACLE_WALLET_DIR/

# Establece la variable de entorno
ENV TNS_ADMIN=/app/Wallet_tienda

# Copia el JAR generado en el contenedor
COPY target/tienda-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8081 porque usuario tiene 8080
EXPOSE 8081

# Comando para ejecutar la aplicación cuando el contenedor arranque
ENTRYPOINT ["java", "-jar", "app.jar"]

