# 🔗 Encurtador de Links - Spring Boot

## 📑 Sumário

- 📌 Descrição do Projeto
- 🚦 Status do Projeto
- 🛠 Funcionalidades e Demonstração
- 📂 Acesso ao Projeto
- 💻 Tecnologias Utilizadas
---

## 📌 Descrição do Projeto

Este é um projeto chamado Encurte-me, ele se trata de um sistema WEB feito para encurtar links de forma prática e otimizada. A interface Web foi feita utilizando HTML, CSS, JavaScript e Axios para fazer as requisições da API REST desenvolvida com **Spring Boot** e encurtar as URLs longas em códigos curtos únicos. Ele detecta URLs repetidas e retorna o mesmo código sem criar duplicatas, otimizando assim toda a aplicação gerando um retorno mais rápido.

---

## 🚦 Status do Projeto

🟢 Finalizado

---

## 🛠 Funcionalidades e Demonstração da Aplicação

- 🔗 Geração de códigos encurtados para URLs
- 🧠 Verificação de duplicidade: não cria encurtadores duplicados
- 📦 Retorno da URL encurtada via `GET`
- 🧭 Integração com Swagger para testes

### 🔍 Demonstração via Navegador:
Acesse `http://localhost:8080/` e utilize o sistema

### 🔍 Demonstração via Swagger:

Acesse `http://localhost:8080/swagger-ui.html` e utilize o endpoint: 
 - GET /api/link

 **Resposta esperada:**

```text 
localhost:8080/link/a1B2c3D
```
---
## 📂 Acesso ao Projeto

### Clone o repositório:

git clone https://github.com/EnzoRibeiro0/encurte-me.git

### Acesse a pasta do projeto:
cd encurte-me

### Execute o projeto:
`./mvnw spring-boot:run`

### Acesse via navegador:
`http://localhost:8080/swagger-ui/index.html` -> para testes direto na API
#### ou
`http://localhost:8080/` -> para teste completo do sistema

---

## 💻 Tecnologias Utilizadas
- Java 17

- Spring Boot

  - Spring Web

  - Spring Web Services

  - Spring Boot DevTools

  - Lombok

  - Spring Data JPA

  - H2 Database

  - Swagger

  - Thymeleaf

- HTML
- CSS
- JavaScript
- Axios