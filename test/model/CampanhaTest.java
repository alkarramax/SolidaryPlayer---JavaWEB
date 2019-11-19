package model;

import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CampanhaTest {
  
    Campanha c;
    LocalDate data;
    List<Softplayer> lista;
    
    @Before
    public void setUp() {
        c = new Campanha();
        data = LocalDate.now();
    }
    
    @Test
    public void testSetters(){
        c.setId_campanha(2);
        c.setNome("campanha");
        c.setDescricao("doar");
        c.setLocal("Softplan");
        c.setNecessidade("");
        c.setImagem("joao.png");
        c.setData(data);
        c.setAberta(true);
        c.setQuantidadeDeItens(14);
        c.setListaSoftplayers(lista);
        c.setId_necessidade1(12);
        c.setId_necessidade2(11);
    }

    @Test
    public void testGetters(){
        c.getId_campanha();
        c.getNome();
        c.getDescricao();
        c.getLocal();
        c.getNecessidade();
        c.getImagem();
        c.getData();
        c.getQuantidadeDeItens();
        c.isAberta();
        c.getListaSoftplayers();
        c.getId_softplayer();
        c.getId_necessidade1();
        c.getId_necessidade2();
    }
    
    
}
