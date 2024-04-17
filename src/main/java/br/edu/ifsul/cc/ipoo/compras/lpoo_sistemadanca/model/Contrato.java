package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicio;
    
    private Double valorDesconto;
    
    @ManyToOne
    @JoinColumn(name = "forma_pgto_id")
    private FormaPgto formaPagamento;
    
    @OneToMany(mappedBy = "contrato")
    private List<Pagamento> pagamentos;

    public <any> getPagamentos() {
        return pagamentos;
    }

    // Getters e setters
    public void setPagamentos(<any> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPgto getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPgto formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}

