package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LivroService {
    @Autowired
    LivroRepository livroRepository;

    public Livro salvarLivro(LivroRequest livroRequest) {
        Livro livro = requestToLivro(livroRequest);
        return livroRepository.save(livro);
    }


    public Livro requestToLivro(LivroRequest livroRequest) {
        Livro livro = new Livro(); // Instancia um novo objeto Livro
        //BeanUtils.copyProperties(livroRequest, livro); // Copia as propriedades do livroRequest para o livro que é um outro jeito de fazer o que está abaixo
        livro.setTitulo(livroRequest.getTitulo()); // Seta o título do livro
        livro.setAutor(livroRequest.getAutor());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setPreco(livroRequest.getPreco());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

    public LivroRequest livroToRequest(Livro livro) {
        LivroRequest livroRequest = new LivroRequest();
        livroRequest.setTitulo(livro.getTitulo());
        livroRequest.setAutor(livro.getAutor());
        livroRequest.setCategoria(livro.getCategoria());
        livroRequest.setPreco(livro.getPreco());
        livroRequest.setIsbn(livro.getIsbn());
        return livroRequest;
    }

    public List<Livro> buscarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivro(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }



}
