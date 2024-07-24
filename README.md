# Criadouro Picinini API

Projeto para gerenciamento de pássaros para o Criador Picinini.

## Índice

- [Introdução](#introdução)
- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Build](#build)
- [Endpoints](#endpoints)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Introdução

Este projeto é uma API desenvolvida para o gerenciamento de pássaros do Criador Picinini. Ele utiliza Spring Boot e outras tecnologias para fornecer uma solução robusta e escalável.

## Requisitos

- Java 21
- Maven 3.8+
- MySQL

## Instalaç4ão

1. Clone o repositório:
    ```bash
    git clone https://github.com/igorlander/criadouropicinini-api.git
    cd criadouropicinini-api
    ```

2. Configure o banco de dados MySQL no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/criadourodb
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Instale as dependências e compile o projeto:
    ```bash
    mvn clean install
    ```

## Build

Para buildar o projeto, utilize o comando:
```bash
mvn package
```
## Endpoints

CRUD - Especies

```
GET/especies

GET/especies/{id}

GET/especies/{nome}

POST/especies

PUT/especies/{id}

DELETE/especies/{id}

``` 
CRUD - Federações

```
GET/federacoes

GET/federacoes/{id}

GET/federacoes/{nome}

POST/federacoes

PUT/federacoes/{id}

DELETE/federacoes/{id}

``` 

CRUD - clubes

```
GET/clubes

GET/clubes/{id}

GET/clubes/{nome}

POST/clubes

PUT/clubes/{id}

DELETE/clubes/{id}

```

CRUD - Criadores

```
GET/criadores

GET/criadores/{id}

POST/criadores

PUT/criadores/{id}

DELETE/criadores/{id}

``` 
CRUD - Passaros

```
GET/passaros

GET/passaros/{id}

POST/passaros

PUT/passaros/{id}

DELETE/passaros/id

```




