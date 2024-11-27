# Usar uma imagem base do Java
FROM openjdk:21

# Copiar o JAR gerado pelo Maven/Gradle para a imagem
COPY target/asscache-0.0.1-SNAPSHOT.jar app.jar

# Configurar o comando de inicialização
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Use a imagem oficial do MySQL
FROM mysql:latest

# Define as variáveis de ambiente para o banco de dados
ENV MYSQL_ROOT_PASSWORD=Elfen.l1ed
ENV MYSQL_DATABASE=subApp
ENV MYSQL_PASSWORD=Elfen.l1ed

# Exponha a porta do banco de dados
EXPOSE 3306

