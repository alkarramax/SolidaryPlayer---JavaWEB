package Models;

import model.Softplayer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SoftplayerTest {

    private Softplayer s;
    
    
    @Before
    public void setUp(){
        s = new Softplayer();
    }
    
    @Test
    public void set(){
        s.setId_softplayer(3);
        s.setNome("João");
        s.setSobrenome("Clayton");
        s.setEmail("joao@top.com");
        s.setCargo("Coordena tudo");
        s.setUnidade("SENAI todo");
        s.setSenha("joaozin123");
    }
    
    @Test
    public void get(){
        s.getNome();
        s.getSobrenome();
        s.getEmail();
        s.getCargo();
        s.getUnidade();
        s.getSenha();
    }
    
}
