package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Pacote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "A descrição do pacote é obrigatória")
    @Size(max = 120, message = "A descrição do pacote deve conter até 120 caracteres")
    private String descricao;
    
    private Double valor;
    
    @ManyToMany
    @JoinTable(name = "pacote_modalidade",
               joinColumns = @JoinColumn(name = "pacote_id"),
               inverseJoinColumns = @JoinColumn(name = "modalidade_id"))
    private List<Modalidade> modalidades;

    public <any> getModalidades() {
        return modalidades;
    }

    public void setModalidades(<any> modalidades) {
        this.modalidades = modalidades;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Getters e setters
}

