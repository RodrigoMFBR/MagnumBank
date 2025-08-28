# ---------- Etapa de build ----------
FROM maven:3.9.3-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia o pom.xml e o código-fonte
COPY pom.xml .
COPY src ./src

# Empacota a aplicação (gera o JAR)
RUN mvn clean package -DskipTests

# ---------- Etapa de runtime ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o JAR construído na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Comando padrão para rodar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
