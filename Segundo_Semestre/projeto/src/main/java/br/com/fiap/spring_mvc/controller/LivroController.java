package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping("/cadastro")
    public String livroCadastro(Model model) {
        model.addAttribute("livroRequest", new LivroRequest());
        return "livroCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(@Valid LivroRequest livroRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "livroCadastro";
        }
        // mapear livroRequest para livro
        // salvar livro no bd
        livroService.salvarLivro(livroRequest);
        // renderizar a página com a lista de livros cadastrados
        return listarLivros(model);
    }

    @GetMapping("/lista")
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.buscarLivros();
        model.addAttribute("listaLivros", livros);
        return "livroLista";
    }

    @GetMapping("/edicao/{id}")
    public String livroEdicao(@PathVariable Long id, Model model) {
        Livro livro = livroService.buscarLivro(id);
        if (livro == null) {
            return listarLivros(model);
        }
        model.addAttribute("idLivro", id);
        model.addAttribute("livro", livroService.livroToRequest(livro));
        return "livroEdicao";
    }

    @PostMapping("/editar/{id}")
    public String editarLivro(@PathVariable Long id, @Valid @ModelAttribute LivroRequest livroRequest, Model model) {
        livroService.atualizarLivro(id, livroRequest);
        return listarLivros(model);
    }

    @GetMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id, Model model){
        livroService.deletarLivro(id);
        return listarLivros(model);
    }
}
