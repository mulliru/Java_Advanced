## 📌 **Aula - Criando uma API RESTful em Java**

Este documento contém um resumo dos principais conceitos abordados na aula, incluindo **o que é uma API**, **REST vs. RESTful**, **CRUD**, **DTOs**, **Paginação**, **Validação** e **Tratamento de Exceções**. 🚀

---

## 🔍 **1. O que é uma API?**

Uma **API (Application Programming Interface)** é um conjunto de regras e definições que permite que sistemas diferentes se comuniquem. 

- APIs podem ser usadas para conectar aplicações distintas.
- Exemplo: Um aplicativo móvel pode se comunicar com um servidor remoto através de uma API.

---

## 🌟 **2. REST vs. RESTful**

### ✨ **REST (Representational State Transfer)**

REST é um estilo arquitetural para desenvolvimento de sistemas distribuídos baseado em:
- **Recursos (Resources)**
- **Verbos HTTP (GET, POST, PUT, DELETE)**
- **Representação de dados em JSON ou XML**

### ✨ **RESTful**

Uma API é considerada **RESTful** quando segue os princípios REST, garantindo:
- Stateless (sem estado entre requisições)
- Cacheable (respostas podem ser armazenadas para otimização)
- Interface uniforme (uso consistente dos verbos HTTP)
- Client-Server (separação entre cliente e servidor)

---

## 🔄 **3. CRUD (Create, Read, Update, Delete)**

CRUD representa as operações básicas de um sistema:

| Operação | Método HTTP | Descrição |
|------------|-------------|-------------|
| **Create** | POST | Criar um novo recurso |
| **Read** | GET | Obter informação de um recurso |
| **Update** | PUT/PATCH | Atualizar um recurso existente |
| **Delete** | DELETE | Remover um recurso |

Exemplo de um endpoint RESTful:
```http
GET /api/produtos/1
```

---

## 📝 **4. DTO (Data Transfer Object)**

Os **DTOs** são objetos usados para transferência de dados entre camadas da aplicação.

### ✅ Benefícios:
- Evita expor diretamente a entidade do banco de dados
- Melhora a segurança e desempenho
- Permite manipular apenas os dados necessários

Exemplo de DTO em Java:
```java
public class ProdutoDTO {
    private String nome;
    private double preco;
    
    // Getters e Setters
}
```

---

## 📊 **5. Paginação (Pageable)**

Para lidar com grande volume de dados, utilizamos **paginação** com Spring Data.

### Exemplo de requisição paginada:
```http
GET /api/produtos?page=0&size=10&sort=nome,asc
```

---

## 🔒 **6. Validação (Bean Validation)**

O **Bean Validation** permite adicionar validações automáticas em entidades ou DTOs.

Exemplo com anotações:
```java
public class UsuarioDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @Email(message = "E-mail inválido")
    private String email;
}
```

---

## ⚠ **7. Tratamento de Exceções (Exception Handler)**

O tratamento de exceções melhora a segurança e a experiência do usuário.

Exemplo de um handler global:
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```

---

## 🔍 **8. HATEOAS (Hypermedia as the Engine of Application State)**

O **HATEOAS** permite que a API forneça links dinâmicos para interação, tornando-a mais flexível.

Exemplo:
```json
{
  "id": 1,
  "nome": "Produto A",
  "preco": 99.90,
  "links": [
    { "rel": "self", "href": "/api/produtos/1" },
    { "rel": "delete", "href": "/api/produtos/1" }
  ]
}
```

---

## 📖 **9. Documentação de API**

A documentação ajuda desenvolvedores a entenderem e consumirem a API. Ferramentas comuns incluem:

- **Swagger**: Gera documentação interativa automaticamente.
- **OpenAPI**: Padrão para descrição de APIs.

Exemplo de dependência no `pom.xml`:
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```

---

## 🌐 **10. Deploy e Segurança**

### ✨ **Spring Security**
- Gerencia autenticação e autorização na API.
- Exemplo de configuração básica:
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
}
```

### 🏆 **Próximos Passos**
- Implementar autenticação com JWT.
- Realizar testes unitários e de integração.
- Deploy da API em um ambiente cloud (AWS, Azure, GCP).

---

## ✅ **Resumo Final**

| Conceito | Descrição |
|----------|-------------|
| **RESTful API** | Arquitetura de comunicação de sistemas |
| **CRUD** | Operações básicas de uma API |
| **DTO** | Objeto de Transferência de Dados |
| **Paginação** | Estratégia para otimizar requisições |
| **Validação** | Garantir dados corretos na API |
| **Segurança** | Proteção com Spring Security |

---
