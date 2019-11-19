package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RankingTest {
    
    Ranking r;
    
    @Before
    public void setUp() {
        r = new Ranking();
    }
    
    @Test
    public void testSetters(){
        r.setId_ranking(1);
        r.setPontuacao(1000);
        r.setUnidade("Saúde");
    }
    
    @Test
    public void testGetters(){
        r.getId_ranking();
        r.getPontuacao();
        r.getUnidade();
    }
    
}
