package model;
public class Doacao {
    
    
    private int id_softplayer;
    private int id_campanha;
    private int quantidadeDoada;
    
    private String necessidade;

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

    public String getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }


}
