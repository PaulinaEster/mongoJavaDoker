package com.paulina.mongoJava.Controller;

import com.paulina.mongoJava.Exceptions.LivroNotFoudException;
import com.paulina.mongoJava.Repository.LivroRepository;
import com.paulina.mongoJava.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    @GetMapping("/livros/{id}")
    public Livro getLivro(@PathVariable String id){
        return livroRepository.findById(id).orElseThrow(() -> new LivroNotFoudException(id));
    }

    @DeleteMapping("/livros/{id}")
    public void delete(@PathVariable String id){
        if(!livroExists(id)){
            throw new LivroNotFoudException(id);
        }

        livroRepository.deleteById(id);
    }

    @PostMapping("/livros")
    public void post(@RequestBody Livro livro){
        livroRepository.save(livro);
    }

    @PutMapping("/livros/{id}")
    Livro putLivro(@RequestBody Livro updatedLivro, @PathVariable String id){
        if(!livroExists(id)){
            throw new LivroNotFoudException(id);
        }

        return livroRepository.save(updatedLivro);
    }

    private boolean livroExists(final String id){
        return livroRepository.existsById(id);
    }

}
