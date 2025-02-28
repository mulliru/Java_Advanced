package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping("/cadastro")
    public ModelAndView livroCadastro() {
        ModelAndView mv = new ModelAndView("livroCadastro");
        mv.addObject("livroRequest", new LivroRequest());
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarLivro(@Valid @ModelAttribute LivroRequest livroRequest) {
        // mapear livroRequest para livro
        // salvar livro no bd
        Livro livro = livroService.salvarLivro(livroRequest);
        // renderizar a página com a lista de livros cadastrados
        return listarLivros();
    }

    @GetMapping("/lista")
    public ModelAndView listarLivros(){
        List<Livro> livros = livroService.buscarLivros();
        ModelAndView mv = new ModelAndView("livroLista");
        mv.addObject("listaLivros", livros);
        return mv;
    }

    @GetMapping("/edicao/{id}")
    public ModelAndView livroEdicao(@PathVariable Long id){
        Livro livro = livroService.buscarLivro(id);
        if (livro == null) {
            return listarLivros();
        }
        ModelAndView mv = new ModelAndView("livroEdicao");
        mv.addObject("idLivro", id);
        mv.addObject("livro", livroService.livroToRequest(livro));
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarLivro(@PathVariable Long id, @Valid @ModelAttribute LivroRequest livroRequest){
        livroService.atualizarLivro(id, livroRequest);
        return listarLivros();
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return listarLivros();
    }
}
