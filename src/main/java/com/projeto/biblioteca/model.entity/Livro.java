package com.projeto.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_sequence")
    @SequenceGenerator(name = "livro_sequence", sequenceName = "liv_seq")
    private Long Id;
    private String nome;
    private String autor;

}
