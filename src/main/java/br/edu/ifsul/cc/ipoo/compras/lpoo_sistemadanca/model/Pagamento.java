package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pagamento_id")
    private Integer id;

    @Column(name = "data_vcto", nullable = false)
    private Calendar dataVcto;

    @Column(name = "valor", precision = 2, nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "contrato_id", nullable = false)
    private Contrato contrato;

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public void gerarPagamento(double valor, Calendar dataVcto) {
        this.valor = valor;
        this.dataVcto = dataVcto;
    }
}
