package model;

import org.junit.Before;
import org.junit.Test;

public class NecessidadeTest {
    
    Necessidade n;
    
    @Before
    public void setUp() {
        n = new Necessidade();
    }
    
    @Test
    public void testSetters(){
        n.setId_necessidade(10);
        n.setNecessidade("Alimento");
    }
    
    @Test
    public void testGetters(){
        n.getId_necessidade();
        n.getNecessidade();
    }
    
}
