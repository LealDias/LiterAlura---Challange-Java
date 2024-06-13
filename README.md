# 📚 Literalura

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![Gutendex API](https://img.shields.io/badge/Gutendex%20API-v1.0-lightgrey)

Literalura é uma aplicação que busca e organiza livros da biblioteca digital Gutenberg, utilizando a API Gutendex. O projeto visa facilitar a busca de livros com base em seus títulos e fornecer uma interface organizada para os usuários.

## 🛠️ Funcionalidades

- 🔍 **Busca de Livros**: Pesquise livros por título.
- 📚 **Organização de Livros**: Armazene e organize informações sobre livros e autores.
- 🌐 **Integração com API Gutendex**: Obtenha dados atualizados da biblioteca digital Gutenberg.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **Hibernate**
- **PostgreSQL 15**
- **RestTemplate** para chamadas HTTP
- **Gutendex API** para dados de livros

## 📦 Configuração do Ambiente

### Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [PostgreSQL 15](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/download.cgi)

### Passos para Configuração

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/literalura.git
    cd literalura
    ```

2. Configure o banco de dados PostgreSQL:
    ```sql
    CREATE DATABASE literalura;
    CREATE USER literalura_user WITH ENCRYPTED PASSWORD 'yourpassword';
    GRANT ALL PRIVILEGES ON DATABASE literalura TO literalura_user;
    ```

3. Atualize o arquivo `application.properties` com as configurações do seu banco de dados:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
    spring.datasource.username=literalura_user
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. Execute a aplicação:
    ```bash
    mvn spring-boot:run
    ```

## 📖 Endpoints da API

### Busca de Livros por Título

```http
GET /books?search={title}


