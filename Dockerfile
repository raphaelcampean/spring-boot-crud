# Estágio 1: Build (Compilação)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o código e o pom
COPY pom.xml .
COPY src ./src

# Compila o projeto (pulando testes para ir mais rápido no seu PC)
RUN mvn clean install -DskipTests

# Estágio 2: Run (Execução)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copia o JAR gerado no estágio anterior para a pasta atual (/app)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Usamos ENTRYPOINT para garantir que o Java seja o processo principal
ENTRYPOINT ["java", "-jar", "app.jar"]