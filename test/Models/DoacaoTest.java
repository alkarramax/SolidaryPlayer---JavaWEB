package Models;

import java.util.Date;
import model.Campanha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoacaoTest {
    
    private Campanha d;
    private Date data;
    
    @Before
    public void setUp(){
        d = new Campanha();
        data = new Date();
    }
    
    @Test
    public void set(){
        d.setId_doacao(123);
        d.setImagem("ads");
        d.setEntidade_doacao_fk(2);
        d.setSoftplayer_doacao_fk(3);
        d.setNecessidade_doacao_1_fk(3);
        d.setNecessidade_doacao_2_fk(33);
        d.setNecessidade_doacao_3_fk(13);
        d.setNecessidade_doacao_4_fk(23);
        d.setNome("Roupas");
        d.setDescricao("Precisa-se de roupas");
        d.setLocal("Recepção da Softplan");
        d.setData(data);
        d.setQuantidade_doacao(4);
        d.setAberta(true);
    }
    
    
    @Test
    public void get(){
        d.getId_doacao();
        d.getImagem();
        d.getEntidade_doacao_fk();
        d.getSoftplayer_doacao_fk();
        d.getNecessidade_doacao_1_fk();
        d.getNecessidade_doacao_2_fk();
        d.getNecessidade_doacao_3_fk();
        d.getNecessidade_doacao_4_fk();
        d.getNome();
        d.getDescricao();
        d.getLocal();
        d.getData();
        d.getQuantidade_doacao();
        d.isAberta();
    }
    
}
