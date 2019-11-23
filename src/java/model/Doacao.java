package model;
public class Doacao {
    
    
    private int id_softplayer;
    private int id_campanha;
    private int quantidadeDoada;
    
    private int necessidade_id1;
    private int necessidade_id2;

    public int getId_softplayer() {
        return id_softplayer;
    }

    public void setId_softplayer(int id_softplayer) {
        this.id_softplayer = id_softplayer;
    }

    public int getId_campanha() {
        return id_campanha;
    }

    public void setId_campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public int getQuantidadeDoada() {
        return quantidadeDoada;
    }

    public void setQuantidadeDoada(int quantidadeDoada) {
        this.quantidadeDoada = quantidadeDoada;
    }

    public int getNecessidade_id1() {
        return necessidade_id1;
    }

    public void setNecessidade_id1(int necessidade_id1) {
        this.necessidade_id1 = necessidade_id1;
    }

    public int getNecessidade_id2() {
        return necessidade_id2;
    }

    public void setNecessidade_id2(int necessidade_id2) {
        this.necessidade_id2 = necessidade_id2;
    }
    
    
    
}
