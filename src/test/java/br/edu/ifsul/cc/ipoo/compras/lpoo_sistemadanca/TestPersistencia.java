package br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca;

import br.edu.ifsul.cc.ipoo.compras.lpoo_sistemadanca.dao.PersistenciaJPA;
import org.junit.Test;
/**
 *
 * @author 20211PF.CC0007
 */
public class TestPersistencia {
    
    @Test
    public void testeConexao() {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            System.out.println("Conexao realizada com sucesso");
        } else {
            System.out.println("Falha ao conectar ao banco");
        }
    }
    
}
