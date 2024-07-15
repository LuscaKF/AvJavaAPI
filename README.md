# API Rest para Controle de Contatos

## Descrição do Projeto

Este projeto é uma aplicação API Rest desenvolvida para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada Pessoa pode ter vários Contatos, e a aplicação permite realizar operações CRUD (Criar, Ler, Atualizar, Deletar) tanto na estrutura de Pessoas quanto de Contatos.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada para desenvolver a aplicação.
- **Spring Boot 3.2.7**: Framework utilizado para facilitar a configuração e o desenvolvimento da aplicação.
- **Spring Data JPA**: Projeto do Spring que facilita o acesso a dados com JPA (Java Persistence API).
- **Hibernate**: Implementação de JPA utilizada para persistência de dados.
- **MySQL**: Sistema de gerenciamento de banco de dados utilizado para armazenar os dados.
- **OpenAPI (Swagger)**: Utilizado para documentar a API.

## Requisitos

- **Java 21** instalado.
- **MySQL** instalado.
- **Maven** instalado.

## Configuração do Banco de Dados

Certifique-se de que o MySQL está instalado e rodando em sua máquina. Crie um banco de dados chamado `contatosdb`.

```sql
CREATE DATABASE contatosdb;
```

## Atualize as configurações de conexão do banco de dados no arquivo src/main/resources/application.properties:

``` bash
spring.datasource.url=jdbc:mysql://localhost:3306/contatosdb?useSSL=false
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

# Configuração do Swagger
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

# Execução do Projeto
## Clone o repositório:

```bash
git clone https://github.com/LuscaKF/AvJavaAPI.git
Navegue até o diretório do projeto:

cd ControlContacts
Configure o banco de dados conforme instruções acima.

Compile e execute a aplicação:

mvn spring-boot:run
Acesse a documentação da API:

Abra seu navegador e vá para: http://localhost:8080/swagger-ui.html
```

# Endpoints da API

## Pessoa

POST /api/pessoas
Cria uma nova Pessoa.

Exemplo de Request:

``` json
{
  "nome": "João Silva",
  "endereco": "Rua A, 123",
  "cep": "12345-678",
  "cidade": "São Paulo",
  "uf": "SP",
  "contatos": []
}
```

GET /api/pessoas/{id}
Retorna os dados de uma Pessoa por ID.


GET /api/pessoas/{id}/malaDireta
Retorna os dados de uma Pessoa por ID para mala direta.

Exemplo de Response:

```json
Nome: Lucas Kirow Fernandes, Endereço: Rua Helena, 269, CEP: 06320310, Cidade: Carapicuíba, UF: SP
```

GET /api/pessoas
Lista todas as Pessoas.


PUT /api/pessoas/{id}
Atualiza uma Pessoa existente.


DELETE /api/pessoas/{id}
Remove uma Pessoa por ID.

Contato
POST /api/contatos
Adiciona um novo Contato a uma Pessoa.

Exemplo de Request:

```json
{
  "tipoContato": "TELEFONE",
  "contato": "1234-5678",
  "pessoa": {
    "id": 1
  }
}
```

GET /api/contatos/{id}
Retorna os dados de um Contato por ID.


GET /api/contatos/pessoa/{idPessoa}
Lista todos os Contatos de uma Pessoa.


PUT /api/contatos/{id}
Atualiza um Contato existente por ID.


DELETE /api/contatos/{id}
Remove um Contato por ID.

# Documentação da API
## A documentação completa da API, incluindo detalhes sobre todos os endpoints, pode ser acessada via Swagger em: http://localhost:8080/swagger-ui.html

# Estrutura do Projeto
## A estrutura básica do projeto é a seguinte:


## ControlContacts
- │
- ├── src
- │   ├── main
- │   │   ├── java
- │   │   │   └── br
- │   │   │       └── com
- │   │   │           └── lkf
- │   │   │               └── ControlContacts
- │   │   │                   ├── controllers
- │   │   │                   ├── model
- │   │   │                   ├── repository
- │   │   │                   ├── service
- │   │   │                   └── ControlContactsApplication.java
- │   │   └── resources
- │   │       ├── application.properties
- │   │       └── ...
- │   └── test
- │       └── java
- │           └── br
- │               └── com
- │                   └── lkf
- │                       └── ControlContacts
- │                           └── ControlContactsApplicationTests.java
- └── pom.xml

## Especificações dos arquivos
- controllers: Contém os controladores da API.
- model: Contém as entidades JPA.
- repository: Contém os repositórios JPA.
- service: Contém a lógica de negócios.
- resources: Contém os arquivos de configuração, como application.properties.
- ControlContactsApplication.java: Classe principal da aplicação Spring Boot.
- ControlContactsApplicationTests.java: Classe de testes da aplicação.

  Exemplos em imagemns:

POST de pessoa:
![image](https://github.com/LuscaKF/AvJavaAPI/assets/62342102/3ccbf81f-d4d5-455d-b562-109f8fe01a53)

POST de contato:
![image](https://github.com/LuscaKF/AvJavaAPI/assets/62342102/876b564a-b9d0-4b8f-bc17-4cd000dd6420)

SHOW de contatos por pessoa:
![image](https://github.com/LuscaKF/AvJavaAPI/assets/62342102/55df3f7c-0d59-45a8-b406-60f131f60c4c)

MalaDiretaDTO:
![image](https://github.com/LuscaKF/AvJavaAPI/assets/62342102/cc97f5ab-40cc-43ce-8b6e-cbc960b85412)
