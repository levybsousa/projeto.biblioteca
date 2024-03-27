package com.projeto.biblioteca.service;

import com.projeto.biblioteca.exception.RecursoNaoEncontradoException;
import com.projeto.biblioteca.model.entity.LivroEntity;
import com.projeto.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<LivroEntity> getAll() {
        List<LivroEntity> result = livroRepository.findAll();
        return result;
    }

    public LivroEntity getById(Long id) {
        Optional<LivroEntity> result = livroRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RecursoNaoEncontradoException("Livro não encontrado");
        }
    }

    public LivroEntity save(LivroEntity livroEntity) {

        Optional<LivroEntity> livroFromDataBase = livroRepository.getLivroByNome(livroEntity.getNome());

        if (livroFromDataBase.isPresent()) {
            throw new RecursoNaoEncontradoException();
        }
        LivroEntity result = livroRepository.save(livroEntity);
        return result;
    }

    public LivroEntity update(Long id, LivroEntity livroEntity) {
        this.getById(id);

        Optional<LivroEntity> livroFromDataBase = livroRepository.getLivroByNome(livroEntity.getNome());

        LivroEntity result = livroRepository.save(livroEntity);
        return result;
    }

    public void delete(Long id) {
        getById(id);
        livroRepository.deleteById(id);
    }

    public String emprestarLivro(String nomeLivro) {
         Optional<LivroEntity> livro = livroRepository.getLivroByNome(nomeLivro);
        if (!livro.isPresent()) {
            return "O livro não existe";
        }
        return "O livro alugado com sucesso";
    }
}



