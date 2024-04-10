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
    @Test
    public void testePersistenciaModalidade() throws Exception {
        
        Modalidade m = new Modalidade();
        m.setDescricao("Modalidade");
        //p.setValor(Double.parseDouble("5000"));
        
        jpa.persist(m);
        
        Modalidade persistidoProduto = (Modalidade)jpa.find(Modalidade.class, m.getId());
        
        Assert.assertEquals(m.getDescricao(), persistidoProduto.getDescricao());
    }
    
    
    
}
