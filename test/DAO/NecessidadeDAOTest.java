package DAO;

import java.util.List;
import model.Necessidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NecessidadeDAOTest {
    
    private NecessidadeDAO nDAO;
    private Necessidade n;
    
    public NecessidadeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nDAO = new NecessidadeDAOImpl();
        n = new Necessidade();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        nDAO.inserir(n);
    }

    @Test
    public void testRemover() {
        nDAO.remover(3);
    }

    @Test
    public void testListar() {
        nDAO.listar();
    }

    @Test
    public void testBuscar() {
        nDAO.buscar(1);
    }

    @Test
    public void testEditar() {
        nDAO.editar(n);
    }

    public class NecessidadeDAOImpl implements NecessidadeDAO {

        public void inserir(Necessidade necessidade) {
        }

        public void remover(int id) {
        }

        public List<Necessidade> listar() {
            return null;
        }

        public Necessidade buscar(int id) {
            return null;
        }

        public void editar(Necessidade necessidade) {
        }
    }
    
}
