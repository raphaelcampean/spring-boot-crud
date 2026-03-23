# spring-boot-crud

# 🧪 Spring Boot User Management Lab

Este repositório contém uma API REST para gestão de utilizadores, desenvolvida de forma 100% independente para validar conhecimentos em Java, Spring Boot e persistência de dados.

## 🧠 Desafios Superados
- **Configuração de Permissões no Postgres**: Resolução de erros de DDL no schema public do Linux.
- **Segurança**: Configuração de `SecurityFilterChain` para permitir testes via ApiDog.
- **Arquitetura**: Organização de pastas seguindo o padrão `Controller -> Service -> Infrastructure/Entity`.

## ⚙️ Como rodar
```bash
mvn clean install -DskipTests
mvn spring-boot:run
