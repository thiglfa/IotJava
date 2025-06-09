Plataforma de Denúncia de Riscos Ambientais - Documentação
markdown
# 📋 Plataforma de Denúncia de Rossos Ambientais

API REST para registro e gerenciamento de denúncias ambientais com autenticação JWT

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.1.0**
- **Spring Security**
- **JWT Authentication**
- **Spring Data JPA**
- **H2 Database (dev) / PostgreSQL (prod)**
- **Swagger UI**

## 📋 Pré-requisitos

- JDK 17+
- Maven 3.8+
- Docker (opcional para deploy)

## ⚙️ Configuração

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/denuncia-ambiental.git
Configure o arquivo application.properties:

properties
# Banco de dados (H2 para desenvolvimento)
spring.datasource.url=jdbc:h2:mem:denuncia_db
spring.datasource.username=sa
spring.datasource.password=

# JWT
jwt.secret=5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437
jwt.expiration=86400000 # 24h
Execute a aplicação:

bash
mvn spring-boot:run
🔐 Autenticação
Registrar novo usuário
http
POST /api/auth/registro
Content-Type: application/json

{
  "nome": "Usuario Teste",
  "email": "teste@example.com",
  "senha": "senha123",
  "perfil": "CIDADAO"
}
Login
http
POST /api/auth/login
Content-Type: application/json

{
  "email": "teste@example.com",
  "senha": "senha123"
}

Resposta:
{
  "token": "eyJhbGciOi...",
  "tipo": "Bearer"
}
📡 Endpoints Principais
Denúncias
POST /api/denuncias - Criar nova denúncia

GET /api/denuncias - Listar denúncias (com paginação)

GET /api/denuncias/{id} - Detalhes de uma denúncia

PUT /api/denuncias/{id}/status - Atualizar status

🛠️ Testando a API
Via Swagger UI
Acesse: http://localhost:8080/swagger-ui.html

Faça login primeiro

Clique no botão "Authorize" e cole o token

Via Postman
Importe a coleção do Postman (disponível em /docs/postman)

Execute o fluxo:

Registro → Login → Operações protegidas

🐳 Docker (Deploy)
Construa a imagem:

bash
docker build -t denuncia-ambiental .
Execute o container:

bash
docker run -p 8080:8080 denuncia-ambiental
🧪 Testes Automatizados
Execute os testes com:

bash
mvn test
