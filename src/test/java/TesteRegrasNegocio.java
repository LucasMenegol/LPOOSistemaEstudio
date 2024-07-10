import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.*;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteRegrasNegocio {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TesteRegrasNegocio() {
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
    public void testCalcularFolhaMes() throws Exception {
        Professores prof = new Professores();
        prof.setNome("Professor A");
        prof.setFone("123456789");
        prof.setDataAniver(Calendar.getInstance());
        prof.setEmail("prof@exemplo.com");
        prof.setEndereco("Endereço 123");
        prof.setDataAdmissao(Calendar.getInstance());

        FolhaPagamento folha = new FolhaPagamento();
        folha.setDataPgto(Calendar.getInstance());
        folha.setProfessor(prof);
        folha.setHorasTrabalhadas(160);  // Suponhamos 160 horas trabalhadas no mês
        folha.setBonus(500.0);  // Bônus de R$ 500,00

        folha.calcularFolhaMes();

        assertEquals(8500.0, folha.getValorReceber(), 0.01);  // 160*50 + 500 = 8500

        jpa.persist(prof);
        jpa.persist(folha);
    }

    @Test
    public void testGerarPagamento() throws Exception {
        Contrato contrato = new Contrato();
        contrato.setValor(2000.0);
        contrato.setForma_pgto(FormaPgto.PIX);

        Pagamento pagamento = new Pagamento();
        Calendar dataVcto = Calendar.getInstance();
        dataVcto.add(Calendar.MONTH, 1);  // Pagamento para o próximo mês

        pagamento.setContrato(contrato);
        pagamento.gerarPagamento(2000.0, dataVcto);

        assertEquals(2000.0, pagamento.getValor(), 0.01);
        assertEquals(dataVcto, pagamento.getDataVcto());

        jpa.persist(contrato);
        jpa.persist(pagamento);
    }
}

