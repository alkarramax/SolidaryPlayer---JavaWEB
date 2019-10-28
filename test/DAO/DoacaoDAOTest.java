package DAO;

import java.util.List;
import model.Doacao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoacaoDAOTest {
    
    private DoacaoDAO dDAO;
    private Doacao d;
    
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
        d = new Doacao();
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

        public void inserir(Doacao doacao) {
        }

        public void remover(int id) {
        }

        public List<Doacao> listar() {
            return null;
        }

        public Doacao buscar(int id) {
            return null;
        }

        public void editar(Doacao doacao) {
        }
    }
    
}
