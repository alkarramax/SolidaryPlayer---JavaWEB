package model;

public class Ranking {
    
    private int id_ranking;
    private int pontuacao;
    private String unidade;
    private int softplayer_ranking_fk;
    

    
    
    
    
    
    //MÉTODOS ESPECIAIS
    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getSoftplayer_ranking_fk() {
        return softplayer_ranking_fk;
    }

    public void setSoftplayer_ranking_fk(int softplayer_ranking_fk) {
        this.softplayer_ranking_fk = softplayer_ranking_fk;
    }
    
}
