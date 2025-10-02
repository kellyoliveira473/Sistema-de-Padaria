Sistema de Padaria

Sistema de gerenciamento para padarias desenvolvido em Java com Spring Boot.

🚀 Tecnologias Utilizadas

Java: Linguagem de programação principal.

Spring Boot: Framework para construção de aplicações Java.

Maven: Gerenciador de dependências e automação de builds.

Docker: Contêineres para facilitar o desenvolvimento e implantação.

👩‍💻 Autora

Kelly Oliveira

📦 Pré-requisitos

Antes de rodar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

Java 17 ou superior

Maven

Docker

📥 Como Rodar o Projeto

Clone este repositório:

git clone https://github.com/kellyoliveira473/Sistema-de-Padaria.git
cd Sistema-de-Padaria


Compile o projeto:

./mvnw clean install


Execute a aplicação:

./mvnw spring-boot:run


A aplicação estará disponível em http://localhost:8080
.

🔧 Endpoints Disponíveis

Observação: Os endpoints exatos não estão documentados no repositório. Recomenda-se verificar o código-fonte para detalhes sobre os endpoints disponíveis.

🧪 Testes

Para rodar os testes automatizados:

./mvnw test

🧱 Estrutura de Pastas
├── .mvn/              # Wrapper do Maven
├── src/               # Código-fonte da aplicação
│   ├── main/
│   │   ├── java/      # Código Java
│   │   └── resources/ # Arquivos de configuração
├── .gitignore         # Arquivos a serem ignorados pelo Git
├── Dockerfile         # Arquivo para construção da imagem Docker
├── mvnw               # Wrapper do Maven para Linux/Mac
├── mvnw.cmd           # Wrapper do Maven para Windows
└── pom.xml            # Arquivo de configuração do Maven

📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE
 para detalhes.
