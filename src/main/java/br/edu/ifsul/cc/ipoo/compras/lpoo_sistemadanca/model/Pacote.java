package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_pacote")
public class Pacote {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "pacote_id")
    private int id;
    
    @Column(name = "pacote_descricao", nullable = false, length = 120)
    private String descricao;
    
    @Column(name = "pacote_valor", nullable = false, precision = 2)
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
    
    
}

