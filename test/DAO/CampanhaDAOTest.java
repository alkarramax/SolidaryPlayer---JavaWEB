package DAO;

import java.util.List;
import model.Campanha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CampanhaDAOTest {
    
    private CampanhaDAO cDAO;
    private Campanha c;
    
    public CampanhaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cDAO = new CampanhaDAOImpl();
        c = new Campanha();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        cDAO.inserir(c);
    }

    @Test
    public void testRemover() {
        cDAO.remover(3);
    }

    @Test
    public void testListar() {
        cDAO.listar();
    }

    @Test
    public void testBuscar() {
        cDAO.buscar(2);
    }

    @Test
    public void testEditar() {
        cDAO.buscar(4);
    }

    public class CampanhaDAOImpl implements CampanhaDAO {

        public void inserir(Campanha campanha) {
        }

        public void remover(int id) {
        }

        public List<Campanha> listar() {
            return null;
        }

        public Campanha buscar(int id) {
            return null;
        }

        public void editar(Campanha campanha) {
        }
    }
    
}
