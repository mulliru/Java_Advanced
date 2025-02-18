package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.model.Categoria;
import br.com.fiap.spring_mvc.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/ola")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello"; // Nome do template HTML, ex: hello.html
    }

    @GetMapping("/ola2")
    public ModelAndView hello2() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", "Helooooooo");
        return mv;
    }

    @GetMapping("/livro")
    public ModelAndView livro() {
        Livro livro = new Livro();
        livro.setAutor("Homero");
        livro.setTitulo("Odisseia");
        livro.setCategoria(Categoria.ROMANCE);
        Livro livro2 = new Livro();
        livro2.setAutor("Homero");
        livro2.setTitulo("Iliada");
        livro.setCategoria(Categoria.FATASIA);
        List<Livro> livros = Arrays.asList(livro, livro2);
        ModelAndView mv = new ModelAndView("livro");
        mv.addObject("livro", livro);
        mv.addObject("livros", livros);
        return mv;
    }

}