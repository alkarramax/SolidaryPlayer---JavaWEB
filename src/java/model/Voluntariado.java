package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voluntariado {
    private int id_voluntariado;
    private String nome, descricao, local, imagem;
    private LocalDate data;
    private LocalTime hora;
    private boolean presenca, aberta;

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


    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }
    
    
    
    
    
    
    
}
