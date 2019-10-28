package Models;

import model.Necessidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NecessidadeTest {
    
    private Necessidade n;
    
    
    @Before
    public void setUp(){
        n = new Necessidade();
    }
    
    @Test
    public void set(){
        n.setId_necessidade(2);
        n.setNecessidade("Comida");
    }
    
    @Test
    public void get(){
        n.getId_necessidade();
        n.getNecessidade();
    }
    
}
