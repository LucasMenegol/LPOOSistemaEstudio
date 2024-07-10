package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pessoa_id")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "fone", nullable = false, length = 15)
    private String fone;

    @Column(name = "data_aniver", nullable = false)
    private Calendar dataAniver;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Calendar getDataAniver() {
        return dataAniver;
    }

    public void setDataAniver(Calendar dataAniver) {
        this.dataAniver = dataAniver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
