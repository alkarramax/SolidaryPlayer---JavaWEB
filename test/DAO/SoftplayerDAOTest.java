package DAO;

import java.util.List;
import model.Softplayer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SoftplayerDAOTest {
    
    private SoftplayerDAO sDAO;
    private Softplayer s;
    
    public SoftplayerDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sDAO = new SoftplayerDAOImpl();
        s = new Softplayer();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        sDAO.inserir(s);
    }

    @Test
    public void testRemover() {
        sDAO.remover(2);
    }

    @Test
    public void testListar() {
        sDAO.listar();
    }

    @Test
    public void testBuscar() {
        sDAO.buscar("joao@edu.com");
    }

    @Test
    public void testEditar() {
    }

    public class SoftplayerDAOImpl implements SoftplayerDAO {

        public void inserir(Softplayer softplayer) {
        }

        public void remover(int id) {
        }

        public List<Softplayer> listar() {
            return null;
        }

        public Softplayer buscar(String email) {
            return null;
        }

        public void editar(Softplayer softplayer) {
        }
    }
    
}
