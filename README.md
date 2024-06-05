
# API Serviço de usuario ST1 - Fiap

Serviço criado utilizando Spring Cloud.\

Responsável pelos cadastros e buscas de usuário no sistema.

Requisitos para rodar:\
Java 22\
Docker(opcional, caso queira montar a imagem e executar)\
https://docs.docker.com/desktop/install/windows-install/ \
https://docs.docker.com/desktop/install/linux-install/

antes de rodar o projeto, o banco de dados de usuário deve ser criado:
na pasta pgCompose tem um docker-compose.yml
utilize-o para rodar o banco de dados antes de rodar o projeto

Possibilidade de utilização do Docker para rodar\
Versão da openjdk para rodar: 22-jdk-slim

Como gerar imagem Docker para poder rodar:\
docker build -t user-service:0.0.1 .

Possui docker-compose para executar após gerar imagem:\
user-service\docker-compose.yml

Para subir a image, basta rodar (você precisa ter o docker instalado):\
docker-compose up -d

Observação, caso queira rodar em docker ou direto da IDE, ajustar o application properties
quando for utilizar o gateway para acesso. Dentro do properties tem as orientações.