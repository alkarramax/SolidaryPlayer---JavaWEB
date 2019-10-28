package Models;

import model.Voluntariado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoluntariadoTest {
    
    private Voluntariado v; 
    
    
    @Before
    public void setUp(){
        v = new Voluntariado();
    }
    
    
    @Test
    public void set(){
        v.setId_voluntariado(12);
        v.setImagem("ASDASD");
        v.setEntidade_voluntariado_fk(1);
        v.setSoftplayer_voluntariado_fk(3);
        v.setNecessidade_voluntariado_1_fk(3);
        v.setNecessidade_voluntariado_2_fk(23);
        v.setNecessidade_voluntariado_3_fk(33);
        v.setNecessidade_voluntariado_4_fk(41);
        v.setNome("Cortar cabelo");
        v.setDescricao("cortar cabelo dos idosos");
        v.setLocal("Na praça 15");
        v.setPresenca(false);
        v.setAberta(true);
    }
    
    
    @Test
    public void get(){
        v.getId_voluntariado();
        v.getImagem();
        v.getEntidade_voluntariado_fk();
        v.getSoftplayer_voluntariado_fk();
        v.getNecessidade_voluntariado_1_fk();
        v.getNecessidade_voluntariado_2_fk();
        v.getNecessidade_voluntariado_3_fk();
        v.getNecessidade_voluntariado_4_fk();
        v.getNome();
        v.getDescricao();
        v.getLocal();
        v.isPresenca();
        v.isAberta();
    }
    
}
