package com.senai.eli.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grupo")
@Getter
@Setter
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "reponsavel")
    private String responsavel;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "email")
    private String email;
}
