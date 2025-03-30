package br.com.fiap.springmvc.controller;

import br.com.fiap.springmvc.model.Receita;
import br.com.fiap.springmvc.repository.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping
    public String listarReceitas(Model model) {
        model.addAttribute("listaReceitas", receitaRepository.findAll());
        return "receita/list";
    }

    @GetMapping("/nova")
    public String novaReceita(Model model) {
        model.addAttribute("receita", new Receita());
        return "receita/form";
    }

    @PostMapping("/salvar")
    public String salvarReceita(@Valid @ModelAttribute("receita") Receita receita, BindingResult result) {
        if (result.hasErrors()) {
            return "receita/form";
        }
        receitaRepository.save(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/editar/{id}")
    public String editarReceita(@PathVariable Long id, Model model) {
        Receita receita = receitaRepository.findById(id).orElseThrow();
        model.addAttribute("receita", receita);
        return "receita/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirReceita(@PathVariable Long id) {
        receitaRepository.deleteById(id);
        return "redirect:/receitas";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
