# Serviço Rest 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/sandroabrantes/agamentos-api/blob/main/LICENSE) 

## Sobre o projeto

Demonstração de uma API REST com alguns endpoints

## Tecnologias utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Spring Data JPA
- Flyway
- Bean Validation
- Lombok
- Modelmapper
- Maven
- Banco de dados: Postgresql

## Como executar o projeto
   - Crie um usuário no Postgres com o nome "teste" e senha "teste"
   - Crie um banco de dados no Postgres com o nome "pagamento"
   - Importe o projeto no STS ou outro semelhante
   - Execute o projeto no STS para que o Flyway crie a tabela no banco de dados e popule-a com uma massa de dados inicial

## Para consumir a API, utilize o Postman ou outra ferramenta para testar os endpoints
   - POST http://localhost:8080/v1/contas
     {
        "nome": "PASSAGEM AÉREA PARA BH",
        "valorOriginal": 912.25,
        "dataVencimento": "2022-01-19",
        "dataPagamento": "2022-01-20"
      }
   
   
   - PUT http://localhost:8080/v1/contas/12
      {
          "nome": "PASSAGEM AÉREA PARA SALVADOR xxx",
          "valorOriginal": 812.25,
          "dataVencimento": "2022-01-12",
          "dataPagamento": "2022-01-16"
      }
      
      
   - GET http://localhost:8080/v1/contas/6
   
   
   - GET http://localhost:8080/v1/contas
   
   
   - GET http://localhost:8080/v1/contas/pesquisa?nome=esco&dataVencimentoDe=2022-01-11&dataVencimentoAte=2022-01-21
   
   
   - DELETE http://localhost:8080/v1/contas/1
      
      
      

## Autor

Sandro Abrantes

https://github.com/sandroabrantes
