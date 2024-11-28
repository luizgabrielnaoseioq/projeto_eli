package com.senai.eli.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name ="numero")
    private int numero;

    @Column(name = "cep", nullable = false, length = 9)
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cep;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();
    
}