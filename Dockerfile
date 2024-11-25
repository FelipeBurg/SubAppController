# Usar uma imagem base do Java
FROM openjdk:21

# Copiar o JAR gerado pelo Maven/Gradle para a imagem
COPY target/asscache-0.0.1-SNAPSHOT.jar app.jar

# Configurar o comando de inicialização
ENTRYPOINT ["java", "-jar", "/app.jar"]
