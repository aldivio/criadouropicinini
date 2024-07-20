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

## Instalação

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
GET/especies/id

{
    "id": 1,
    "nome": "XXXX",
    "nomeCientifico": "XXXXXX"
}
GET/especies

[
    {
        "id": 1,
        "nome": "XXXX",
        "nomeCientifico": "XXXX"
    },
    {
        "id": 2,
        "nome": "YYYYY",
        "nomeCientifico": "YYYY"
    },...

POST/especies
{
    "nome": "YYYY",
    "nomeCientifico": "YYYY"
}
PUT/especies/id
{
    "nome": "YYYY",
    "nomeCientifico": "YYYY"
}
DELETE/especies/id

``` 
CRUD - clubes

```
GET/clubes/id

{
  {
    "id": 1,
    "codigo": " ",
    "nome": " "
}
}
GET/clubes

[
    {
        "id": 1,
        "codigo": " ",
        "nome": " "
    },
    {
        "id": 2,
        "codigo": "000",
        "nome": "..."
    },

POST/clubes
{
    "codigo": "0000",
    "nome": "XXXXX"
}
PUT/clubes/id
{
    "codigo": "0000",
    "nome": "XXXX"
}
DELETE/clubes/id

```
CRUD - Federações

```
GET/federacoes/id

{
  {
    "id": 1,
    "codigo": " ",
    "nome": " "
}
}
GET/federacoes

[
    {
        "id": 1,
        "codigo": " ",
        "nome": " "
    },
    {
        "id": 2,
        "codigo": "000",
        "nome": "..."
    },

POST/federacoes
{
    "codigo": "0000",
    "nome": "XXXXX"
}
PUT/federacoes/id
{
    "codigo": "0000",
    "nome": "XXXX"
}
DELETE/federacoes/id

``` 

CRUD - Criadores

```
GET/criadores/id

{
  {
    "id": 1,
    "codigo": " ",
    "nome": " "
}
}
GET/criadores

[
    {
        "id": 1,
        "codigo": " ",
        "nome": " "
    },
    {
        "id": 2,
        "codigo": "000",
        "nome": "..."
    },

POST/criadores
{
    "codigo": "0000",
    "nome": "XXXXX"
}
PUT/criadores/id
{
    "codigo": "0000",
    "nome": "XXXX"
}
DELETE/criadores/id

``` 
CRUD - Passaros

```
GET/passaros/id

{
    "id": 16,
    "especie": {
        "id": 2,
        "nome": "XXXXX",
        "nomeCientifico": "XXXXX"
    },
    "federacao": {
        "id": 2,
        "codigo": ".",
        "nome": "."
    },
    "clube": {
        "id": 34,
        "codigo": "XXXXX",
        "nome": "XXXXX"
    },
    "criador": {
        "id": 1,
        "codigo": "XXXXX",
        "nome": "XXXXX"
    },
    "numeroAnel": "012",
    "ano": "XX/XX",
    "tamanhoAnel": "XXX",
    "anilha": "X XX/XX XXX XXX . XXXX XXXX",
    "nome": "XXXXXX",
    "sexo": "XXXX",
    "numeroSexagem": 4,
    "dataNascimento": "2024-08-21T00:00:00Z",
    "dataAquisicao": "2024-06-11T00:00:00Z",
    "dataSaida": "2024-06-11T00:00:00Z",
    "dataObito": "2024-06-11T00:00:00Z",
    "causaObito": "",
    "passaroPai": {
        "id": 8,
        "especie": {
            "id": 1,
            "nome": "XXXXX",
            "nomeCientifico": "XXXXXX"
        },
        "federacao": {
            "id": 2,
            "codigo": ".",
            "nome": "."
        },
        "clube": {
            "id": 26,
            "codigo": "XXXXX",
            "nome": "XXXXXXXX"
        },
        "criador": {
            "id": 1,
            "codigo": "XXXX,
            "nome": "XXXXX"
        },
        "numeroAnel": "012",
        "ano": "XX/XX",
        "tamanhoAnel": "XXX",
        "anilha": "XXXX XX/XX XXX XXX . XXXX XXX",
        "nome": "XXXXXX",
        "sexo": "XXXXXX",
        "numeroSexagem": 1,
        "dataNascimento": "2024-06-11T00:00:00Z",
        "dataAquisicao": "2024-06-11T00:00:00Z",
        "dataSaida": "2024-06-11T00:00:00Z",
        "dataObito": "2024-06-11T00:00:00Z",
        "causaObito": "",
        "passaroPai": null,
        "passaroMae": null,
        "cliente": {
            "id": 1,
            "nome": "XXXXX",
            "endereco": "XXXXXX",
            "bairro": "XXXXXX",
            "cidade": "XXXXX",
            "uf": "XX",
            "cep": "XXXXXXX",
            "email": "XXXXXhotmail.com",
            "nomeContato": "XXX",
            "cpfCnpj": "000.000.000-90",
            "observacao": "XXXXXX"
        },
        "numeroCtp": 10,
        "situacao": "A_VENDA",
        "observacao": "observacao"
    },
    "passaroMae": {
        "id": 11,
        "especie": {
            "id": 2,
            "nome": "XXXXX",
            "nomeCientifico": "XXXXX"
        },
        "federacao": {
            "id": 2,
            "codigo": ".",
            "nome": "."
        },
        "clube": {
            "id": 34,
            "codigo": "XXXXX",
            "nome": "XXXXX"
        },
        "criador": {
            "id": 1,
            "codigo": "XXX",
            "nome": "XXXXXX"
        },
        "numeroAnel": "XXX",
        "ano": "XX/XX",
        "tamanhoAnel": "XXX",
        "anilha": "X XX/XX XXX XXX . XXXX XXX",
        "nome": "XXXXXX",
        "sexo": "XXXXX",
        "numeroSexagem": 1,
        "dataNascimento": "2024-06-11T00:00:00Z",
        "dataAquisicao": "2024-06-11T00:00:00Z",
        "dataSaida": "2024-06-11T00:00:00Z",
        "dataObito": "2024-06-11T00:00:00Z",
        "causaObito": "",
        "passaroPai": {
            "id": 9,
            "especie": {
                "id": 1,
                "nome": "XXXX",
                "nomeCientifico": "XXXXXX"
            },
            "federacao": {
                "id": 2,
                "codigo": ".",
                "nome": "."
            },
            "clube": {
                "id": 26,
                "codigo": "XXXXX",
                "nome": "XXXXXX"
            },
            "criador": {
                "id": 1,
                "codigo": "XXX",
                "nome": "XXXXXX"
            },
            "numeroAnel": "012",
            "ano": "XX/XX",
            "tamanhoAnel": "014",
            "anilha": "X XX/XX XXX XXX . XXXXX XXX",
            "nome": "XXXXX",
            "sexo": "INDEFINIDO",
            "numeroSexagem": 1,
            "dataNascimento": "2024-06-11T00:00:00Z",
            "dataAquisicao": "2024-06-11T00:00:00Z",
            "dataSaida": "2024-06-11T00:00:00Z",
            "dataObito": "2024-06-11T00:00:00Z",
            "causaObito": "",
            "passaroPai": null,
            "passaroMae": null,
            "cliente": {
                "id": 1,
                "nome": "XXXX",
                "endereco": "XXXXXXX",
                "bairro": "XXXXXX",
                "cidade": "XXXXX",
                "uf": "XX",
                "cep": "0000000",
                "email": "XXXXX@hotmail.com",
                "nomeContato": "XXXX",
                "cpfCnpj": "000.000.000-00",
                "observacao": "XXXXX"
            },
            "numeroCtp": 10,
            "situacao": "XXXXX",
            "observacao": "observacao"
        },
        "passaroMae": {
            "id": 10,
            "especie": {
                "id": 3,
                "nome": "XXXXX",
                "nomeCientifico": "XXXXX"
            },
            "federacao": {
                "id": 2,
                "codigo": ".",
                "nome": "."
            },
            "clube": {
                "id": 11,
                "codigo": "XXXXX",
                "nome": "..."
            },
            "criador": {
                "id": 1,
                "codigo": "XXX",
                "nome": "XXXXXXX"
            },
            "numeroAnel": "XXX",
            "ano": "XX/XX",
            "tamanhoAnel": "014",
            "anilha": "X XX/XX XXX XXX . XXXXX XXX",
            "nome": "XXXXXX",
            "sexo": "XXXXXX",
            "numeroSexagem": 1,
            "dataNascimento": "2024-06-11T00:00:00Z",
            "dataAquisicao": "2024-06-11T00:00:00Z",
            "dataSaida": "2024-06-11T00:00:00Z",
            "dataObito": "2024-06-11T00:00:00Z",
            "causaObito": "",
            "passaroPai": null,
            "passaroMae": null,
            "cliente": {
                "id": 1,
                "nome": "XXXX",
                "endereco": "XXXXXXXX",
                "bairro": "XXXXXX",
                "cidade": "XXXXXX",
                "uf": "XX",
                "cep": "00000",
                "email": "XXXX@hotmail.com",
                "nomeContato": "XXXX",
                "cpfCnpj": "XXX.XXX.XXX-XX",
                "observacao": "XXXXX"
            },
            "numeroCtp": 10,
            "situacao": "XXXX",
            "observacao": "XXXX"
        },
        "cliente": {
            "id": 1,
            "nome": "XXX",
            "endereco": "XXXX",
            "bairro": "XXXXX",
            "cidade": "XXXXX",
            "uf": "XX",
            "cep": "0000000",
            "email": "XXXX@hotmail.com",
            "nomeContato": "XXX",
            "cpfCnpj": "XXX.XXX.XXX-XX",
            "observacao": "XXXXXX"
        },
        "numeroCtp": 10,
        "situacao": "XXXXXX",
        "observacao": "XXXXXX"
    },
    "cliente": {
        "id": 1,
        "nome": "XXXXXX",
        "endereco": "XXXXXX",
        "bairro": "XXXXXX",
        "cidade": "XXXXXX",
        "uf": "XX",
        "cep": "000000",
        "email": "XXXXXX@hotmail.com",
        "nomeContato": "XXXXXX",
        "cpfCnpj": "XXX.XXX.XXX-XX",
        "observacao": "XXXXXX"
    },
    "numeroCtp": 10,
    "situacao": "XXXXXX",
    "observacao": "XXXXXX"
}
GET/passaros

[
    {
        "id": 1,
        "codigo": " ",
        "nome": " "
    },
    {
        "id": 2,
        "codigo": "000",
        "nome": "XXXX"
    },

POST/passaros
{
    "especie": {
        "id": 1
        },
    "federacao": {
        "id": 2
    },
    "clube": {
        "id": 34
        },
    "criador": {
        "id": 1
        },
    "numeroAnel": "012",
    "ano": "00/00",
    "tamanhoAnel": "000",
    "nome": "XXXXXXX",
    "sexo": "XXXXXX",
    "numeroSexagem": 1,
    "dataNascimento": "2024-06-11T00:00:00Z",
    "dataAquisicao": "2024-06-11T00:00:00Z",
    "dataSaida": "2024-06-11T00:00:00Z",
    "dataObito": "2024-06-11T00:00:00Z",
    "causaObito": "",
    "passaroPai": {
        "id": 8
            },
    "passaroMae": {
            "id":11
            },
    "cliente": {
        "id": 1        
    },
    "numeroCtp": 10,
    "situacao": "XXXX",
    "observacao": "observacao"
}
PUT/passaros/id
{
    "codigo": "0000",
    "nome": "XXXX"
}
DELETE/passaros/id

```




