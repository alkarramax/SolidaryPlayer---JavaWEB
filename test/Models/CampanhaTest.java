package Models;

import java.util.Date;
import model.Campanha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CampanhaTest {
    
    Campanha c = new Campanha();
    Date dI = new Date();
    Date dT = new Date();
    
    public CampanhaTest() {
    }
    
    @Test
    public void set() {
        c.setId_campanha(0212);
        c.setImagem("imagem kkk");
        c.setEntidade_campanha_fk(1);
        c.setSoftplayer_campanha_fk(3);
        c.setNecessidade_campanha_1_fk(1);
        c.setNecessidade_campanha_2_fk(3);
        c.setNecessidade_campanha_3_fk(5);
        c.setNecessidade_campanha_4_fk(12);
        c.setNome("Filosofia");
        c.setDescricao("Trata-se de beneficios beneficos");
        c.setLocal("SENAI");
        c.setData(dI);
        c.setPresenca(true);
        c.setAberta(true);
    }
    
    @Test
    public void get(){
        c.getId_campanha();
        c.getImagem();
        c.getEntidade_campanha_fk();
        c.getSoftplayer_campanha_fk();
        c.getNecessidade_campanha_1_fk();
        c.getNecessidade_campanha_2_fk();
        c.getNecessidade_campanha_3_fk();
        c.getNecessidade_campanha_4_fk();
        c.getNome();
        c.getDescricao();
        c.getLocal();
        c.getData();
        c.isPresenca();
        c.isAberta();
    }
    

}
