package com.senai.eli.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

@Table(name = "evento")
@Entity
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "aprovado", nullable = false)
    @ColumnDefault("false")
    private boolean aprovado = false;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "valor", nullable = false)
    @ColumnDefault("0")
    private double valor = 0;

    @Column(name = "banner", nullable = false)
    private String banner;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "indexador")
    private String indexador;

    @Column(name = "responsavel", nullable = false)
    private String responsavel;

    @Column(name = "cronograma", nullable = false)
    private String cronograma;

    @ManyToAny
    @JoinTable(name = "evento_calendario")
    private List<Calendario> calendarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne
    private Grupo grupo;

    public Grupo getGrupo() {
        return grupo;
    }

    @ManyToOne
    private Categoria categoria;
}