package model;

import java.time.LocalDate;

public class Campanha {
    
    private int id_campanha;
    private String nome, descricao, local, imagem;
    private LocalDate dataInicio, dataTermino;
    private Softplayer id_softplayer;
    private Necessidade id_necessidade;

    public int getId_campanha() {
        return id_campanha;
    }

    public void setId_campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }


    public Softplayer getId_softplayer() {
        return id_softplayer;
    }

    public void setId_softplayer(Softplayer id_softplayer) {
        this.id_softplayer = id_softplayer;
    }

    public Necessidade getId_necessidade() {
        return id_necessidade;
    }

    public void setId_necessidade(Necessidade id_necessidade) {
        this.id_necessidade = id_necessidade;
    }
    
    
    
    
   
}
