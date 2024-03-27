package com.projeto.biblioteca.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data

public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
