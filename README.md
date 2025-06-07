# UserServiceAPI

Projeto base para curso de Microserviços com Java Spring Boot e MySQL.

## 📚 Descrição
API de usuários construída com Spring Boot, conectada a um banco MySQL, pronta para ser usada como microserviço em uma arquitetura maior. Inclui seed de dados, endpoints REST e estrutura recomendada para projetos reais.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL (via Docker)
- Maven

## ⚙️ Requisitos
- Java 17 ou superior
- Maven
- Docker (para rodar o MySQL)

## 🐬 Subindo o MySQL com Docker
Execute no terminal:
```sh
docker run --name meu-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=userservicedb -p 3306:3306 -d mysql:8.0
```

## 🔧 Configuração
O arquivo `src/main/resources/application.properties` já está configurado para conectar ao banco MySQL rodando em `localhost:3306`:
```properties
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/userservicedb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.initialization-mode=always
```

## 🏗️ Rodando o Projeto
1. Clone o repositório
2. Suba o MySQL (veja acima)
3. Execute:
   ```sh
   ./mvnw spring-boot:run
   ```

## 🌱 Seed de Dados
O arquivo `src/main/resources/data.sql` insere usuários automaticamente ao iniciar o app:
```sql
INSERT INTO user (name, email) VALUES ('Martins', 'martins@email.com');
INSERT INTO user (name, email) VALUES ('Ana', 'ana@email.com');
INSERT INTO user (name, email) VALUES ('Carlos', 'carlos@email.com');
```

## 🧩 Estrutura do Projeto
```
src/main/java/com/java/microservicos/UserServiceAPI/
  controllers/
  models/
  repositories/
  services/
src/main/resources/
  application.properties
  data.sql
```

## 📖 Exemplos de Endpoints
- `GET /users` — Lista todos os usuários
- `GET /users/{id}` — Busca usuário por ID
- `GET /users/by-ids?ids=1,2,3` — Busca múltiplos usuários por IDs
- `POST /users` — Cria um novo usuário (ou retorna existente se email já cadastrado)
  - Body:
    ```json
    {
      "name": "Danilo",
      "email": "danilo@teste.com"
    }
    ```

## ℹ️ Observações
- O endpoint de criação valida nome, formato do email e unicidade do email.
- Se o email já existir, retorna o usuário existente.
- Respostas de erro seguem o padrão JSON com mensagem.

---

![Arquitetura de Microserviços](microservicos.jpg)
