package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
}
