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
- `POST /users` — Cria um novo usuário
  - Exemplo de body:
    ```json
    { "name": "João", "email": "joao@email.com" }
    ```
- `GET /hello` — Teste simples
- `GET /` — Mensagem de status da API

## 📝 Observações
- O projeto está pronto para ser expandido com novas entidades e microserviços.
- Para resetar o banco, basta remover o volume do container MySQL ou dropar as tabelas manualmente.

---

Desenvolvido para fins educacionais no curso de Microserviços com Java Spring Boot + MySQL.
