# 📚 Literalura

![image](https://github.com/LealDias/LiterAlura---Challange-Java/assets/70763447/ab7d3368-00fa-4471-a515-fec3fe58ef4a)

Literalura é uma aplicação que busca e organiza livros da biblioteca digital Gutenberg, utilizando a API Gutendex. O projeto visa facilitar a busca de livros com base em seus títulos e fornecer uma interface organizada para os usuários.

## 🛠️ Funcionalidades
🔍 Busca de Livros: Pesquise livros por título.
📚 Organização de Livros: Armazene e organize informações sobre livros e autores.
🌐 Integração com API Gutendex: Obtenha dados atualizados da biblioteca digital Gutenberg.

##🚀 Tecnologias Utilizadas
Java 17
Spring Boot 3.3.0
Hibernate
PostgreSQL 15
RestTemplate para chamadas HTTP
Gutendex API para dados de livros

## 📦 Configuração do Ambiente
Pré-requisitos
Java 17
PostgreSQL 15
Maven
Passos para Configuração
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/literalura.git
cd literalura
Configure o banco de dados PostgreSQL:

sql
Copiar código
CREATE DATABASE literalura;
CREATE USER literalura_user WITH ENCRYPTED PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE literalura TO literalura_user;
Atualize o arquivo application.properties com as configurações do seu banco de dados:

properties
Copiar código
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=literalura_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Execute a aplicação:

bash
Copiar código
mvn spring-boot:run

## 📖 Endpoints da API
Busca de Livros por Título
http
Copiar código
GET /books?search={title}
Parâmetro: title - Título do livro a ser buscado.
Resposta: Lista de livros que correspondem ao título pesquisado.

## 👨‍💻 Contribuindo
Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b feature/AmazingFeature).
Commit suas mudanças (git commit -m 'Add some AmazingFeature').
Faça um push para a branch (git push origin feature/AmazingFeature).
Abra um Pull Request.

## 📝 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.

📞 Contato
Para mais informações, entre em contato pelo email lealexpertsecurity@gmail.com.
