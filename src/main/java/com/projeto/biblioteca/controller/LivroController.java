package com.projeto.biblioteca.controller;

import com.projeto.biblioteca.model.entity.LivroEntity;
import com.projeto.biblioteca.service.LivroService;
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
    public ResponseEntity<List<LivroEntity>> getAll() {
        List<LivroEntity> livroEntityResponse = livroService.getAll();
        return ResponseEntity.ok(livroEntityResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroEntity> getById(@PathVariable Long id) {
        LivroEntity livroEntityResponse = livroService.getById(id);
        return ResponseEntity.ok(livroEntityResponse);
    }

    @PostMapping
    public ResponseEntity<LivroEntity> save(@RequestBody LivroEntity livroEntity) {
        LivroEntity livroEntityResponse = livroService.save(livroEntity);
        return ResponseEntity.ok(livroEntityResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroEntity> update(@PathVariable Long id, @RequestBody LivroEntity livroEntity) {
        LivroEntity livroEntityResponse = livroService.update(id, livroEntity);
        return ResponseEntity.ok(livroEntityResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
