package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SoftplayerTest {
    
    Softplayer s;
    
    @Before
    public void setUp() {
        s = new Softplayer();
    }
    
    
    @Test
    public void testSetters(){
        s.setId_softplayer(14);
        s.setNome("João");
        s.setEmail("joao@gmail.com");
        s.setCargo("Coordenador");
        s.setUnidade("Justiça");
        s.setSenha("123321");
    }
    
    @Test
    public void testGetters(){
        s.getId_softplayer();
        s.getNome();
        s.getEmail();
        s.getCargo();
        s.getUnidade();
        s.getSenha();
    }
    
}
