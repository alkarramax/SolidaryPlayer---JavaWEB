package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Necessidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JDBCNecessidadeDAOTest {
    
    Necessidade n;
    JDBCNecessidadeDAO nDAO;
    
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        n = new Necessidade();
        n.setId_necessidade(10);
        n.setNecessidade("Alimento");
        
        nDAO = new JDBCNecessidadeDAO();
    }
    
    @Test
    public void testInserir() {
        nDAO.inserir(n);
    }

    @Test
    public void testRemover() {
        nDAO.remover(1);
    }

    @Test
    public void testListar() {
        nDAO.listar();
    }

    @Test
    public void testBuscar() {
        nDAO.buscar(3);
    }

    @Test
    public void testEditar() {
        nDAO.editar(n);
    }
    
}
