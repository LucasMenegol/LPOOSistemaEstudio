import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.*;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistenciaObjetos {
    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaObjetos() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void test() throws Exception {
        Modalidade m = new Modalidade();
        m.setDescricao("Dança Livre");

        Pacote pct = new Pacote();
        pct.setDescricao("3x");
        pct.setValor(100);
        pct.setModalidade(m);

        Contrato c = new Contrato();
        c.setValor(20.678);
        c.setForma_pgto(FormaPgto.PIX);

        Pagamento p = new Pagamento();
        p.setValor(200.00);
        p.setDataVcto(Calendar.getInstance());
        p.setContrato(c);

        Professores prof = new Professores();
        prof.setNome("Professor A");
        prof.setFone("123456789");
        prof.setDataAniver(Calendar.getInstance());
        prof.setEmail("prof@exemplo.com");
        prof.setEndereco("Endereço 123");
        prof.setDataAdmissao(Calendar.getInstance());
        
        Alunos aluno = new Alunos();
        aluno.setNome("Aluno A");
        aluno.setFone("987654321");
        aluno.setDataAniver(Calendar.getInstance());
        aluno.setEmail("aluno@exemplo.com");
        aluno.setEndereco("Endereço 456");
        aluno.setDataInicio(Calendar.getInstance());
        aluno.setDataPgto(15);

        FolhaPagamento folha = new FolhaPagamento();
        folha.setDataPgto(Calendar.getInstance());
        folha.setValorReceber(1500.00);
        folha.setProfessor(prof);

        jpa.persist(m);
        jpa.persist(pct);
        jpa.persist(c);
        jpa.persist(p);
        jpa.persist(prof);
        jpa.persist(aluno);
        jpa.persist(folha);
    }
}
