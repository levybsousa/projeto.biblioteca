package com.projeto.biblioteca.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_sequence")
    @SequenceGenerator(name = "livro_sequence", sequenceName = "liv_seq")
    private Long Id;
    private String nome;
    private String autor;

}
