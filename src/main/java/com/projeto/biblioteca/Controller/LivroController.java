package com.projeto.biblioteca.Controller;

import com.projeto.biblioteca.model.entity.Livro;
import com.projeto.biblioteca.service.LivroService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/livros")
@RequiredArgsConstructor
@RestController
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long Id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Livro> save(@PathVariable Long Id, @RequestBody Livro livro) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long Id, @RequestBody Livro livro) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return null;
    }
}
