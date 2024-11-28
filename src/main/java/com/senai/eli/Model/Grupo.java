package com.senai.eli.Model;

import java.util.List;

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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "reponsavel", nullable = false)
    private String responsavel;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "grupo")
    private List<Evento> eventos;
    
}