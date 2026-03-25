---

# Spring Boot User Management & Auth Lab

Este repositório contém uma API REST robusta para gestão de usuários e autenticação, desenvolvida para validar conhecimentos avançados em Java, Spring Boot e segurança digital.



## Novas Funcionalidades & Desafios Superados

- **Autenticação JWT**: Implementação de fluxo completo de segurança com `JWT (JSON Web Token)`, incluindo geração e validação de tokens.
- **RBAC (Role-Based Access Control)**: Controle de acesso granular onde apenas usuários com a role `ADMIN` podem listar todos os usuários, enquanto rotas de login e cadastro são públicas.
- **Dockerização Completa**: Ambiente 100% isolado com `Docker Compose`, gerenciando o container da aplicação Spring Boot e o banco de dados PostgreSQL.
- **Arquitetura Profissional**: Organização em camadas seguindo o padrão `Controller -> Service -> Repository -> Model`, utilizando **Java Records** para DTOs (Data Transfer Objects).
- **Gestão de Segredos**: Configuração de segurança via variáveis de ambiente (`.env`), garantindo que credenciais sensíveis nunca vazem para o controle de versão.

## Tecnologias Utilizadas

* **Java 17+** & **Spring Boot 3**
* **Spring Security** (Autenticação e Autorização)
* **Auth0 JWT** (Geração de tokens)
* **PostgreSQL** (Banco de dados relacional)
* **Docker & Docker Compose** (Containerização)
* **Hibernate/JPA** (Persistência de dados)

---

## Como Rodar o Projeto

### 1. Pré-requisitos
* Docker e Docker Compose instalados.
* Um cliente HTTP (como **Apidog**, Postman ou Insomnia).

### 2. Configuração do Ambiente
Crie um arquivo `.env` na raiz do projeto com base no arquivo `.env.example`:

```properties
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=seu_segredo_super_secreto
```

### 3. Subindo os Containers
No terminal, dentro da pasta raiz, execute:

```bash
docker compose up -d --build
```

A API estará disponível em `http://localhost:8080`.

---

## Principais Endpoints

| Método | Endpoint | Acesso | Descrição |
| :--- | :--- | :--- | :--- |
| **POST** | `/auth/login` | Público | Autentica usuário e retorna o Token JWT. |
| **POST** | `/users` | Público | Cadastra um novo usuário no sistema. |
| **GET** | `/users` | **ADMIN** | Lista todos os usuários (Exige Bearer Token). |

---

## Aprendizados de Infraestrutura
Durante o desenvolvimento, foi implementada a comunicação entre containers via rede interna do Docker, substituindo o `localhost` pelo nome do serviço de banco de dados no `docker-compose.yml`, garantindo a resiliência da conexão JDBC.

---
