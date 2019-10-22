package model;

import java.util.Date;

public class Campanha {
    
    private int id_campanha;
    private String imagem;
    private int entidade_campanha_fk, softplayer_campanha_fk, necessidade_campanha_1_fk,
            necessidade_campanha_2_fk, necessidade_campanha_3_fk, necessidade_campanha_4_fk;
    
    private String nome, descricao, local;
    private Date data_inicio, data_termino;
    private boolean presenca, aberta;

    
    
    
    
    //MÉTODOS ESPECIAIS
    public int getId_campanha() {
        return id_campanha;
    }

    public void setId_campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getEntidade_campanha_fk() {
        return entidade_campanha_fk;
    }

    public void setEntidade_campanha_fk(int entidade_campanha_fk) {
        this.entidade_campanha_fk = entidade_campanha_fk;
    }

    public int getSoftplayer_campanha_fk() {
        return softplayer_campanha_fk;
    }

    public void setSoftplayer_campanha_fk(int softplayer_campanha_fk) {
        this.softplayer_campanha_fk = softplayer_campanha_fk;
    }

    public int getNecessidade_campanha_1_fk() {
        return necessidade_campanha_1_fk;
    }

    public void setNecessidade_campanha_1_fk(int necessidade_campanha_1_fk) {
        this.necessidade_campanha_1_fk = necessidade_campanha_1_fk;
    }

    public int getNecessidade_campanha_2_fk() {
        return necessidade_campanha_2_fk;
    }

    public void setNecessidade_campanha_2_fk(int necessidade_campanha_2_fk) {
        this.necessidade_campanha_2_fk = necessidade_campanha_2_fk;
    }

    public int getNecessidade_campanha_3_fk() {
        return necessidade_campanha_3_fk;
    }

    public void setNecessidade_campanha_3_fk(int necessidade_campanha_3_fk) {
        this.necessidade_campanha_3_fk = necessidade_campanha_3_fk;
    }

    public int getNecessidade_campanha_4_fk() {
        return necessidade_campanha_4_fk;
    }

    public void setNecessidade_campanha_4_fk(int necessidade_campanha_4_fk) {
        this.necessidade_campanha_4_fk = necessidade_campanha_4_fk;
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

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
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
