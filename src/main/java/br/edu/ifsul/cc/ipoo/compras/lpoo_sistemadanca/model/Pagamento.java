package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 20211PF.CC0007
 */
@Entity
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de vencimento é obrigatória")
    private Calendar dataVcto;
    private Double valor;
    private Calendar dataPgto;
    private Double valorPgto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataVcto() {
        return dataVcto;
    }

    public void setDataVcto(Calendar dataVcto) {
        this.dataVcto = dataVcto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Calendar dataPgto) {
        this.dataPgto = dataPgto;
    }

    public Double getValorPgto() {
        return valorPgto;
    }

    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }
    
    
    
}
