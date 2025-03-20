package br.com.fiap.spring_mvc.service;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
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

    public void atualizarLivro(Long id, LivroRequest livroRequest) {
        Livro livro = buscarLivro(id);
        if (livro != null) {
            BeanUtils.copyProperties(livroRequest, livro);
            livroRepository.save(livro);
        }
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public Livro requestToLivro(LivroRequest livroRequest) {
        Livro livro = new Livro();
        //BeanUtils.copyProperties(livroRequest, livro);
        livro.setTitulo(livroRequest.getTitulo());
        livro.setAutor(livroRequest.getAutor());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setPreco(livroRequest.getPreco());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

    public LivroRequest livroToRequest(Livro livro) {
        LivroRequest livroRequest = new LivroRequest();
        BeanUtils.copyProperties(livro, livroRequest);
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
