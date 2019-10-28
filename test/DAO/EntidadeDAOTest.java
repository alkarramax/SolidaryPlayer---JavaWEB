package DAO;

import java.util.List;
import model.Entidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntidadeDAOTest {
    
    private EntidadeDAO eDAO;
    private Entidade e;
    
    public EntidadeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        eDAO = new EntidadeDAOImpl();
        e = new Entidade();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        eDAO.inserir(e);
    }

    @Test
    public void testRemover() {
        eDAO.remover(19);
    }

    @Test
    public void testListar() {
        eDAO.listar();
    }

    @Test
    public void testBuscar() {
        eDAO.buscar(6);
    }

    @Test
    public void testEditar() {
        eDAO.editar(e);
    }

    public class EntidadeDAOImpl implements EntidadeDAO {

        public void inserir(Entidade entidade) {
        }

        public void remover(int id) {
        }

        public List<Entidade> listar() {
            return null;
        }

        public Entidade buscar(int id) {
            return null;
        }

        public void editar(Entidade entidade) {
        }
    }
    
}
