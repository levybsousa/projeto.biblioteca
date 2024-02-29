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
        List<Livro> livroResponse = livroService.getAll();
        return ResponseEntity.ok(livroResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        Livro livroResponse = livroService.getById(id);
        return ResponseEntity.ok(livroResponse);
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro livroResponse = livroService.save(livro);
        return ResponseEntity.ok(livroResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        Livro livroResponse = livroService.update(id, livro);
        return ResponseEntity.ok(livroResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
