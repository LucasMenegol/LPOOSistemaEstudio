package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_professor")
public class Professores extends Pessoas {

    @Column(name = "data_admissao", nullable = false)
    private Calendar dataAdmissao;

    @OneToMany(mappedBy = "professor")
    private List<FolhaPagamento> folhasPagamento;

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public List<FolhaPagamento> getFolhasPagamento() {
        return folhasPagamento;
    }

    public void setFolhasPagamento(List<FolhaPagamento> folhasPagamento) {
        this.folhasPagamento = folhasPagamento;
    }
}

