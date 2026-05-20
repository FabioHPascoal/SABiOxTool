# Stage 1: Build da aplicação usando Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copia os arquivos de configuração do Maven e o código-fonte
COPY pom.xml .
COPY src ./src

# Executa o comando de build do Maven dentro do container
RUN mvn clean package -DskipTests

# Stage 2: Imagem final leve apenas para rodar o .jar
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copia o .jar gerado no Stage 1 para a imagem final
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]