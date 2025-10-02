# Estágio 1: Build da Aplicação
# Usa uma imagem com Maven + JDK já instalados
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Executa o build do projeto e empacota a aplicação em um arquivo .jar
RUN mvn clean package -DskipTests

# Estágio 2: Criação da Imagem de Execução
# Usa apenas o JRE para deixar a imagem final mais leve
FROM eclipse-temurin:17-jre-focal

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Expõe a porta da aplicação (Spring Boot normalmente usa 8080)
EXPOSE 8080

# Copia o JAR gerado no estágio de build
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
