package DAO;

import java.util.List;
import model.Campanha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoacaoDAOTest {
    
    private DoacaoDAO dDAO;
    private Campanha d;
    
    public DoacaoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dDAO = new DoacaoDAOImpl();
        d = new Campanha();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        dDAO.inserir(d);
    }

    @Test
    public void testRemover() {
        dDAO.remover(4);
    }

    @Test
    public void testListar() {
        dDAO.listar();
    }

    @Test
    public void testBuscar() {
        dDAO.buscar(3);
    }

    @Test
    public void testEditar() {
        dDAO.editar(d);
    }

    public class DoacaoDAOImpl implements DoacaoDAO {

        public void inserir(Campanha doacao) {
        }

        public void remover(int id) {
        }

        public List<Campanha> listar() {
            return null;
        }

        public Campanha buscar(int id) {
            return null;
        }

        public void editar(Campanha doacao) {
        }
    }
    
}
