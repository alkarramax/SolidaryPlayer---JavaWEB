package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import model.Campanha;
import org.junit.Before;
import org.junit.Test;

public class JDBCCampanhaDAOTest {
    
    Campanha c;
    JDBCCampanhaDAO cDAO;
    LocalDate data;
    
    
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        data = LocalDate.now();
        
        c = new Campanha();
        c.setId_campanha(0);
        c.setNome("campanha");
        c.setDescricao("doar");
        c.setLocal("Softplan");
        c.setImagem("joao.png");
        c.setData(data);
        c.setAberta(true);
        c.setId_necessidade(1);
        
        cDAO = new JDBCCampanhaDAO();
    }
    
    
    @Test
    public void testInserir() {
        cDAO.inserir(c);
    }

    @Test
    public void testRemover() {
        cDAO.remover(34);
        cDAO.remover(35);
        cDAO.remover(36);
    }
    
    @Test
    public void testListar() throws Exception {
        cDAO.listar();
    }

    
    @Test
    public void testBuscar() {
        cDAO.buscar(22);
    }
    
}
