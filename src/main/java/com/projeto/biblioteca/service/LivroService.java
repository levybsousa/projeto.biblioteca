package com.projeto.biblioteca.service;

import com.projeto.biblioteca.exception.RecursoNaoEncontradoException;
import com.projeto.biblioteca.model.entity.Livro;
import com.projeto.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> getAll() {
        List<Livro> result = livroRepository.findAll();
        return result;
    }

    public Livro getById(Long id) {
        Optional<Livro> result = livroRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RecursoNaoEncontradoException("Livro não encontrado");
        }
    }

    public Livro save(Livro livro) {

        Optional<Livro> livroFromDataBase = livroRepository.getLivroByNome(livro.getNome());

        if (livroFromDataBase.isPresent()) {
            throw new RecursoNaoEncontradoException();
        }
        Livro result = livroRepository.save(livro);
        return result;
    }
    public Livro update(Long id, Livro livro) {
        this.getById(id);

        Optional<Livro> livroFromDataBase = livroRepository.getLivroByNome(livro.getNome());

        Livro result = livroRepository.save(livro);
        return result;
    }

    public void delete(Long id)  {
        getById(id);
        livroRepository.deleteById(id);
    }
}



