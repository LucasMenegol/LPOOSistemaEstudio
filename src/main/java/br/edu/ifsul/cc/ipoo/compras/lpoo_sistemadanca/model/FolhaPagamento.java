package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "tb_folha_pagamento")
public class FolhaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "folha_pagamento_id")
    private Integer id;

    @Column(name = "data_pgto", nullable = false)
    private Calendar dataPgto;

    @Column(name = "valor_receber", precision = 2)
    private double valorReceber;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professores professor;

    @Column(name = "horas_trabalhadas")
    private int horasTrabalhadas;

    @Column(name = "bonus")
    private double bonus;

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void calcularFolhaMes() {
        double taxaHora = 50.0;  // Suponhamos uma taxa de R$ 50,00 por hora
        this.valorReceber = (horasTrabalhadas * taxaHora) + bonus;
    }
}
