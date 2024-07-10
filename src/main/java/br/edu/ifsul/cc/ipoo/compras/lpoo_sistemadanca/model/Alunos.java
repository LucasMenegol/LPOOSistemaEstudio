package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.*;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;

@Entity
@Table(name = "tb_aluno")
public class Alunos extends Pessoas {

    @Column(name = "data_inicio", nullable = false)
    private Calendar dataInicio;

    @Column(name = "data_pgto")
    private int dataPgto;

    @OneToOne(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Contrato contrato;

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(int dataPgto) {
        this.dataPgto = dataPgto;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
