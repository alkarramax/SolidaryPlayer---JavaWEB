package DAO;

import java.util.List;
import model.Voluntariado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoluntariadoDAOTest {

    private VoluntariadoDAO vDAO;
    private Voluntariado v;
    
    public VoluntariadoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vDAO = new VoluntariadoDAOImpl();
        v = new Voluntariado();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInserir() {
        vDAO.inserir(v);
    }

    @Test
    public void testRemover() {
        vDAO.remover(6);
    }

    @Test
    public void testListar() {
        vDAO.listar();
    }

    @Test
    public void testBuscar() {
        vDAO.buscar(19);
    }

    @Test
    public void testEditar() {
        vDAO.editar(v);
    }

    public class VoluntariadoDAOImpl implements VoluntariadoDAO {

        public void inserir(Voluntariado voluntariado) {
        }

        public void remover(int id) {
        }

        public List<Voluntariado> listar() {
            return null;
        }

        public Voluntariado buscar(int id) {
            return null;
        }

        public void editar(Voluntariado voluntariado) {
        }
    }
    
}
