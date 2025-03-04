## 📌 **Aula - Thymeleaf no Spring Boot**

Este documento contém um resumo dos principais conceitos abordados na aula sobre **Thymeleaf**, incluindo **sua integração com Spring Boot**, **sintaxe básica**, **fragmentos**, **dialetos** e **expressões padrão**. 🚀

---

## 🔍 **1. O que é Thymeleaf?**

O **Thymeleaf** é uma engine de template para **Java** que permite criar páginas dinâmicas em **HTML, XML, JavaScript e CSS**.

### ✨ **Principais Características**:
- ✨ **Integração com Spring Boot**: Permite inserir dados do model nos templates.
- ✨ **Sintaxe natural**: Se parece com HTML puro, facilitando a manutenção.
- ✨ **Processamento no Servidor e Cliente**: Pode ser renderizado diretamente no navegador.
- ✨ **Expressões de Template**: Permite manipulação de dados diretamente no HTML.
- ✨ **Dialetos**: Expande a funcionalidade e se integra com outros frameworks.

---

## 📚 **2. Exemplo de Código com Spring Boot**

Para usar o **Thymeleaf** em um projeto **Spring Boot**, é necessário adicionar a seguinte dependência no `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### ✨ **Criando um Controller**:
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

### ✨ **Criando um Template HTML (`index.html`)**:
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

Ao acessar **`localhost:8080/ola`**, o navegador exibirá **"Hello, Mundo!"**.

---

## 🛠 **3. Trabalhando com Fragments**

O **Thymeleaf** permite dividir templates em **fragmentos reutilizáveis**.

### ✨ **Criando um Fragmento (`header.html`)**:
```html
<header th:fragment="cabecalho">
    <h1>Meu Site</h1>
</header>
```

### ✨ **Usando um Fragmento no Template Principal**:
```html
<body>
    <div th:insert="~{header :: cabecalho}"></div>
</body>
```

---

## 🌐 **4. Dialetos do Thymeleaf**

Os **dialetos** do Thymeleaf permitem personalizar e adicionar novas funcionalidades.

### ✨ **SpringStandard Dialect vs Standard Dialect**
- **SpringStandard**: Utiliza o **Spring Expression Language (SpEL)**.
- **Standard**: Baseado no **Object-Graph Navigation Language (OGNL)**.

Os dialetos fornecem atributos como:
- `th:text`: Define o texto do elemento.
- `th:each`: Permite iteração sobre coleções.
- `th:if` / `th:unless`: Controla a exibição condicional de elementos.

---

## 🔢 **5. Expressões Padrão no Thymeleaf**

O Thymeleaf suporta **cinco tipos principais** de expressões:

| Expressão | Descrição |
|-----------|-------------|
| **${...}** | Variáveis do modelo |
| ***{...}** | Seleção de objeto |
| **#{...}** | Mensagens (internacionalização) |
| **@{...}** | Construção de URLs |
| **~{...}** | Referência a fragmentos |

### ✨ **Exemplo de Uso**:
```html
<span th:text="${usuario.nome}"></span>
<li th:each="produto : ${produtos}" th:text="${produto.nome}"></li>
<a th:href="@{/detalhes/{id}(id=${produto.id})}">Ver Detalhes</a>
```

---

## 📚 **6. Operadores e Condicionais**

### ✨ **Booleanos e Comparações**:
```html
<span th:if="${usuario.ativo}">Usuário Ativo</span>
<span th:unless="${usuario.ativo}">Usuário Inativo</span>
```

### ✨ **Concatenação de Strings**:
```html
<p th:text="'Bem-vindo, ' + ${usuario.nome} + '!'">Olá!</p>
```

### ✨ **Operações Matemáticas**:
```html
<p th:text="${preco} * 1.10">Preço com imposto</p>
```

---

## 🔍 **7. Construção de Links**

Thymeleaf permite construir URLs dinâmicas dentro da aplicação:
```html
<a th:href="@{/produtos/{id}(id=${produto.id})}">Detalhes</a>
```
Isso gera um link para `/produtos/1`, substituindo `{id}` pelo valor real.

---

## 🔧 **8. Exemplo Completo de Template**

```html
<div th:object="${produto}">
    <h1 th:text="*{nome}"></h1>
    <p th:text="*{descricao}"></p>
    <p th:text="'Preço: R$ ' + *{preco}"></p>
</div>
```

---

## 🏆 **9. Próximos Passos**
- Aprimorar a aplicação com **formularios dinâmicos**.
- Implementar **autenticação com Spring Security**.
- Adicionar **testes unitários para templates Thymeleaf**.
- Criar templates **responsivos com Bootstrap**.

---