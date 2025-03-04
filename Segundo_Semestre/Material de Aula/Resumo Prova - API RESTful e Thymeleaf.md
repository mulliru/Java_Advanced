## 📌 **Resumo para Prova - API RESTful e Thymeleaf**

Este documento contém um resumo dos principais conceitos abordados nas aulas sobre **API RESTful com Java** e **Thymeleaf no Spring Boot**. Estes conteúdos serão cobrados na prova teórica. 📝

---

# 🚀 **Parte 1: API RESTful com Java**

## ✅ **O que é uma API?**
- API (**Application Programming Interface**) permite a comunicação entre sistemas.
- Utiliza **endpoints** para fornecer acesso a funcionalidades específicas.
- Métodos HTTP comuns:
  - `GET`: Buscar dados.
  - `POST`: Criar dados.
  - `PUT`: Atualizar dados.
  - `DELETE`: Remover dados.

## 🌎 **REST vs RESTful**
- **REST** é um conjunto de princípios para arquiteturas de APIs.
- **RESTful** refere-se a APIs que seguem os princípios REST:
  - Stateless (sem estado entre requisições).
  - Cacheable (possibilidade de armazenar respostas).
  - Interface uniforme (uso consistente de URLs e métodos HTTP).
  - Client-Server (separação entre cliente e servidor).

## 🔄 **CRUD - Operações Básicas**
| Operação  | Método HTTP | Exemplo de Endpoint |
|-----------|------------|----------------------|
| **Criar** | `POST`     | `/api/produtos`      |
| **Ler**   | `GET`      | `/api/produtos/{id}` |
| **Atualizar** | `PUT`  | `/api/produtos/{id}` |
| **Excluir** | `DELETE` | `/api/produtos/{id}` |

## 🛠 **DTO (Data Transfer Object)**
- **DTOs** ajudam a transferir dados entre camadas sem expor entidades diretamente.
- Melhoram segurança e organização do código.

Exemplo:
```java
public class ProdutoDTO {
    private String nome;
    private Double preco;
    // Getters e Setters
}
```

## 📊 **Paginação (Pageable)**
- Permite retornar dados em partes menores.
- Utilizado com **Spring Data**.
- Exemplo:
```http
GET /api/produtos?page=0&size=10&sort=nome,asc
```

## 🔍 **Validação (Bean Validation)**
- Impede entrada de dados inválidos.
- Exemplo:
```java
public class Usuario {
    @NotBlank(message = "Nome não pode estar vazio")
    @Size(min = 3, max = 50)
    private String nome;
}
```

## ⚠ **Tratamento de Exceção (Exception Handler)**
- Melhora a resposta da API em casos de erro.
- Exemplo:
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
```

## 🌐 **HATEOAS e Documentação**
- **HATEOAS**: Adiciona links dinâmicos aos recursos da API.
- **Swagger**: Ferramenta para documentar APIs automaticamente.

---

# 🖥 **Parte 2: Thymeleaf no Spring Boot**

## ✅ **O que é Thymeleaf?**
- **Engine de templates para Java**.
- Cria páginas dinâmicas em **HTML, XML, JavaScript e CSS**.
- **Sintaxe natural** (sem necessidade de tags customizadas).

## 🔗 **Integração com Spring Boot**
Para usar Thymeleaf, adicionar a dependência no `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

## 📝 **Exemplo de Uso**
### **Controller Java:**
```java
@Controller
public class HelloController {
    @GetMapping("/ola")
    public String ola(Model model) {
        model.addAttribute("nome", "Mundo");
        return "index";
    }
}
```

### **Template HTML (`index.html`)**:
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Exemplo Thymeleaf</title>
</head>
<body>
    <h1 th:text="'Hello, ' + ${nome} + '!'">Hello, Mundo!</h1>
</body>
</html>
```

## 🧩 **Trabalhando com Fragments**
- Permite dividir templates em partes reutilizáveis.
- **Exemplo:** Criando um `header.html`:
```html
<header th:fragment="cabecalho">
    <h1>Meu Site</h1>
</header>
```

Usando no template principal:
```html
<div th:insert="~{header :: cabecalho}"></div>
```

## 🛠 **Dialetos no Thymeleaf**
- **Standard Dialect**: Usa OGNL (Object-Graph Navigation Language).
- **SpringStandard Dialect**: Usa Spring Expression Language (SpEL).
- Exemplo:
```html
<span th:text="${usuario.nome}"></span>
<li th:each="produto : ${produtos}" th:text="${produto.nome}"></li>
<a th:href="@{/detalhes/{id}(id=${produto.id})}">Ver Detalhes</a>
```

## 🔢 **Expressões Thymeleaf**
| Expressão | Descrição |
|-----------|-------------|
| **${...}** | Variáveis do modelo |
| ***{...}** | Seleção de objeto |
| **#{...}** | Mensagens (i18n) |
| **@{...}** | Construção de URLs |
| **~{...}** | Referência a fragmentos |

Exemplo de uso:
```html
<div th:object="${produto}">
    <h1 th:text="*{nome}"></h1>
    <p th:text="*{descricao}"></p>
</div>
```

## 📌 **Operadores e Condicionais**
- Booleanos e comparações:
```html
<span th:if="${usuario.ativo}">Usuário Ativo</span>
```
- Concatenação de Strings:
```html
<p th:text="'Bem-vindo, ' + ${usuario.nome} + '!'">Olá!</p>
```
- Operações Matemáticas:
```html
<p th:text="${preco} * 1.10">Preço com imposto</p>
```

## 🔗 **Construção de Links Dinâmicos**
```html
<a th:href="@{/produtos/{id}(id=${produto.id})}">Detalhes</a>
```

## ✅ **Resumo Final**

| Conceito | Descrição |
|----------|-------------|
| **API RESTful** | Interface de comunicação entre sistemas |
| **CRUD** | Operações principais de uma API |
| **DTO** | Transferência segura de dados |
| **Thymeleaf** | Engine de templates para Java |
| **Fragments** | Reutilização de templates |
| **Validação** | Controle de entrada de dados |
| **Exceções** | Tratamento de erros na API |
| **Segurança** | Proteção com Spring Security |

---

**Dica para a prova:** Revise os conceitos e pratique exemplos no Spring Boot! 🚀
