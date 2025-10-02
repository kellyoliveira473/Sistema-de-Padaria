# Estágio 1: Build da Aplicação
# Use uma imagem base com o JDK para compilar o código.
FROM eclipse-temurin:17-jdk-focal as build

# Define o diretório de trabalho dentro do contêiner.
WORKDIR /app

# Copia o arquivo de configuração do Maven para que ele não precise ser baixado toda vez.
COPY pom.xml .hm

# Copia o código-fonte.
COPY src ./src

# Executa o build do projeto e empacota a aplicação em um arquivo .jar.
# O '-DskipTests' evita a execução dos testes, que são desnecessários para o build da imagem.
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# Estágio 2: Criação da Imagem de Execução
# Use uma imagem base leve que contenha apenas o JRE (Java Runtime Environment).
# Isso deixa a imagem final muito menor e mais segura.
FROM eclipse-temurin:17-jre-focal

# Define o diretório de trabalho dentro do contêiner.
WORKDIR /app

# Expõe a porta que sua aplicação Spring Boot utiliza (geralmente 8080).
EXPOSE 8080

# Copia o arquivo .jar da aplicação, que foi criado no primeiro estágio.
# O 'target/*.jar' busca o arquivo gerado pelo Maven.
COPY --from=build /app/target/*.jar app.jar

# Define o comando que será executado quando o contêiner for iniciado.
# Ele executa o arquivo .jar que foi copiado para o contêiner.
ENTRYPOINT ["java", "-jar", "app.jar"]