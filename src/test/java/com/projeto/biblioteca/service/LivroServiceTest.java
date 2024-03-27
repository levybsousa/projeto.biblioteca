package com.projeto.biblioteca.service;

import com.projeto.biblioteca.model.entity.LivroEntity;
import com.projeto.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LivroServiceTest {
    /**
     * 1.Verificar se existe o livro no banco de dados por nome
     * 2. Verificar se o livro está disponível
     * se sim (Alugar o livro)
     * se não ( não está disponível )
     * se não ( Livro não encontrado )
     */

    @Mock
    private LivroRepository livroRepository = mock(LivroRepository.class);
    private LivroService livroService = new LivroService(livroRepository);

    @Test
    void deveEmprestarQuandoExisteEDisponivel() {

        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setNome("Daniel");
        livroEntity.setAutor("Daniel");
        when(livroRepository.getLivroByNome("Daniel")).thenReturn(Optional.of(livroEntity));

        String result = livroService.emprestarLivro("Daniel");
        assertEquals("O livro alugado com sucesso", result);
    }

    @Test
    void naoDeveEmprestarQuandoExisteENaoDisponivel() {
        String result = livroService.emprestarLivro("Pedro");
        assertEquals("O livro não está disponível", result);
    }

    @Test
    void naoDeveEmprestarQuandoNaoExiste() {
        String result = livroService.emprestarLivro("Salmos");
        assertEquals("O livro não existe", result);
    }
}
