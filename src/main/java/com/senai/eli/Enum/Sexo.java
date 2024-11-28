package com.senai.eli.Enum;

public enum Sexo {
    
    MASCULINO(1,'M', "Masculino"), FEMININO(2,'F', "Feminino"), NAO_INFORMADO(3,'N', "Não Informado");

    private final int codigo;
    private final char abreviacao;
    private final String descricao;

    Sexo(int codigo,char abreviacao, String descricao) {
        this.codigo = codigo;
        this.abreviacao = abreviacao;
        this.descricao = descricao;
    }
}
