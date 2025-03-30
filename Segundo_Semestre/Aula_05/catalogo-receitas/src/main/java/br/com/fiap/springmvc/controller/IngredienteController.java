package br.com.fiap.springmvc.controller;

import br.com.fiap.springmvc.model.Ingrediente;
import br.com.fiap.springmvc.model.Receita;
import br.com.fiap.springmvc.repository.IngredienteRepository;
import br.com.fiap.springmvc.repository.ReceitaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping
    public String listarIngredientes(Model model) {
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
        return "ingrediente/list";
    }

    @GetMapping("/novo")
    public String novoIngrediente(Model model) {
        model.addAttribute("ingrediente", new Ingrediente());
        model.addAttribute("receitas", receitaRepository.findAll());
        return "ingrediente/form";
    }

    @PostMapping("/salvar")
    public String salvarIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("receitas", receitaRepository.findAll());
            return "ingrediente/form";
        }

        ingredienteRepository.save(ingrediente);
        return "redirect:/ingredientes";
    }

    @GetMapping("/editar/{id}")
    public String editarIngrediente(@PathVariable Long id, Model model) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow();
        model.addAttribute("ingrediente", ingrediente);
        model.addAttribute("receitas", receitaRepository.findAll());
        return "ingrediente/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirIngrediente(@PathVariable Long id) {
        ingredienteRepository.deleteById(id);
        return "redirect:/ingredientes";
    }
}
