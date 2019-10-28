package Models;

import model.Entidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntidadeTest {
    
    
    private Entidade e;
    
    
    @Before
    public void setUp(){
        e = new Entidade();
    }
    
    @Test
    public void set(){
        e.setId_entidade(2);
        e.setImagem("dsad");
        e.setNome("Ajudadora");
        e.setDescricao("Ela ajuda as pessoas");
        e.setCausa("Ajudar");
        e.setEmail("ajuda@me");
        e.setTelefone("08008000");
    }
    
    @Test
    public void get(){
        e.getId_entidade();
        e.getImagem();
        e.getNome();
        e.getDescricao();
        e.getCausa();
        e.getEmail();
        e.getTelefone();
    }
    
}
