/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca;

import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.Modalidade;
import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.model.Pagamento;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20211PF.CC0007
 */
public class TestePersistenciaDanca {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaDanca() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    =======
    @Test
    public void testePersistenciaModalidade() throws Exception {

        Modalidade m = new Modalidade();
        m.setDescricao("Modalidade");
        //p.setValor(Double.parseDouble("5000"));

        jpa.persist(m);

        Modalidade persistidoProduto = (Modalidade) jpa.find(Modalidade.class, m.getId());

        Assert.assertEquals(m.getDescricao(), persistidoProduto.getDescricao());
    }

    @Test
    public void testePersistenciaPacoteComModalidade() throws Exception {
        // Criando um novo pacote
        Pacote pacote = new Pacote();
        pacote.setDescricao("Pacote de dança");
        pacote.setValor(100.00); // Valor fictício

        // Criando uma modalidade e associando ao pacote
        Modalidade modalidade = new Modalidade();
        modalidade.setDescricao("Modalidade de dança");

        // Associando a modalidade ao pacote
        pacote.getModalidades().add(modalidade);

        // Persistindo o pacote
        jpa.persist(pacote);

        // Buscando o pacote persistido do banco de dados
        Pacote pacotePersistido = (Pacote) jpa.find(Pacote.class, pacote.getId());

        // Verificando se o pacote foi persistido corretamente
        Assert.assertEquals(pacote.getDescricao(), pacotePersistido.getDescricao());
        Assert.assertEquals(pacote.getValor(), pacotePersistido.getValor());
        // Verificando se a modalidade foi associada corretamente ao pacote
        Assert.assertFalse(pacotePersistido.getModalidades().isEmpty());
        Assert.assertEquals(modalidade.getDescricao(), pacotePersistido.getModalidades().get(0).getDescricao());
    }

//@Test
    public void testePersistenciaContratoComPagamento() throws Exception {
        // Criando um novo contrato
        Contrato contrato = new Contrato();
        contrato.setDataInicio(Calendar.getInstance()); // Utiliza a data atual
        contrato.setValorDesconto(50.00); // Valor fictício

        // Criando um pagamento e associando ao contrato
        Pagamento pagamento = new Pagamento();
        pagamento.setDataVcto(Calendar.getInstance()); // Utiliza a data atual
        pagamento.setValor(100.00); // Valor fictício

        // Associando o pagamento ao contrato
        contrato.getPagamentos().add(pagamento);

        // Persistindo o contrato
        jpa.persist(contrato);

        // Buscando o contrato persistido do banco de dados
        Contrato contratoPersistido = (Contrato) jpa.find(Contrato.class, contrato.getId());

        // Verificando se o contrato foi persistido corretamente
        Assert.assertNotNull(contratoPersistido);
        Assert.assertEquals(contrato.getDataInicio(), contratoPersistido.getDataInicio());
        Assert.assertEquals(contrato.getValorDesconto(), contratoPersistido.getValorDesconto());
        // Verificando se o pagamento foi associado corretamente ao contrato
        Assert.assertFalse(contratoPersistido.getPagamentos().isEmpty());
        Assert.assertEquals(pagamento.getDataVcto(), contratoPersistido.getPagamentos().get(0).getDataVcto());
        Assert.assertEquals(pagamento.getValor(), contratoPersistido.getPagamentos().get(0).getValor());
    }

}
