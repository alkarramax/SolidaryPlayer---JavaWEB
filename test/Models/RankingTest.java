package Models;

import model.Ranking;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RankingTest {
    
    Ranking r = new Ranking();
    
    @Test
    public void set(){
        r.setId_ranking(2);
        r.setPontuacao(333);
        r.setUnidade("Justiça");
        r.setSoftplayer_ranking_fk(3);
    }
    
    @Test
    public void get(){
        r.getId_ranking();
        r.getPontuacao();
        r.getUnidade();
        r.getSoftplayer_ranking_fk();
    }
    
}
