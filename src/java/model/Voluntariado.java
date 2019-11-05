package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voluntariado {
    
    private int id_voluntariado;
    private String nome, descricao, local, imagem;

    private LocalDate data;
    private LocalTime hora;
    
    private int id_softplayer;

    //MÉTODOS ESPECIAIS
    public int getId_voluntariado() {
        return id_voluntariado;
    }

    public void setId_voluntariado(int id_voluntariado) {
        this.id_voluntariado = id_voluntariado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getId_softplayer() {
        return id_softplayer;
    }

    public void setId_softplayer(int id_softplayer) {
        this.id_softplayer = id_softplayer;
    }

    
    
    
    
    
    
    
    
}
