# Desafio PicPay

## Descrição
Esse é o desafio do banco digital Picpay, feito em java com Springboot e docker rodando a mysql. Esse desafio tem a finalidade de fazer transferência bancaria entre usuarios e empresas, com tratamento de execeções para evitar erros e transferencias errados como saldo negativo e transferencias entre empresas.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Maven

## Instalação
Passos para instalar e configurar o projeto localmente.

```bash
# Clone o repositório
git clone https://github.com/Hhpp2004/PicPay.git

# Navegue até o diretório do projeto
cd src/main/java/com/example/picpay


# Instale as dependências
# Dependêcias pego no site mvn repository
# URL: https://mvnrepository.com
mysql-connector-j
spring-boot-starter-data-jpa
spring-boot-starter-validation
spring-cloud-starter-openfeign
spring-boot-starter-web
spring-boot-devtools
spring-boot-starter-test

# Execute o projeto
mvn spring-boot:run