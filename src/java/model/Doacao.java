
package model;

import java.util.Date;

public class Doacao {
    
    private int id_doacao;
    private String imagem;
    private int entidade_doacao_fk, softplayer_doacao_fk, necessidade_doacao_1_fk,
            necessidade_doacao_2_fk, necessidade_doacao_3_fk, necessidade_doacao_4_fk;
    
    private String nome, descricao, local;
    private Date data;
    
    private int quantidade_doacao;
    private boolean aberta;
    
    
    
    
    
    
    
    
    //MÉTODOS ESPECIAIS
    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getEntidade_doacao_fk() {
        return entidade_doacao_fk;
    }

    public void setEntidade_doacao_fk(int entidade_doacao_fk) {
        this.entidade_doacao_fk = entidade_doacao_fk;
    }

    public int getSoftplayer_doacao_fk() {
        return softplayer_doacao_fk;
    }

    public void setSoftplayer_doacao_fk(int softplayer_doacao_fk) {
        this.softplayer_doacao_fk = softplayer_doacao_fk;
    }

    public int getNecessidade_doacao_1_fk() {
        return necessidade_doacao_1_fk;
    }

    public void setNecessidade_doacao_1_fk(int necessidade_doacao_1_fk) {
        this.necessidade_doacao_1_fk = necessidade_doacao_1_fk;
    }

    public int getNecessidade_doacao_2_fk() {
        return necessidade_doacao_2_fk;
    }

    public void setNecessidade_doacao_2_fk(int necessidade_doacao_2_fk) {
        this.necessidade_doacao_2_fk = necessidade_doacao_2_fk;
    }

    public int getNecessidade_doacao_3_fk() {
        return necessidade_doacao_3_fk;
    }

    public void setNecessidade_doacao_3_fk(int necessidade_doacao_3_fk) {
        this.necessidade_doacao_3_fk = necessidade_doacao_3_fk;
    }

    public int getNecessidade_doacao_4_fk() {
        return necessidade_doacao_4_fk;
    }

    public void setNecessidade_doacao_4_fk(int necessidade_doacao_4_fk) {
        this.necessidade_doacao_4_fk = necessidade_doacao_4_fk;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade_doacao() {
        return quantidade_doacao;
    }

    public void setQuantidade_doacao(int quantidade_doacao) {
        this.quantidade_doacao = quantidade_doacao;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }
    
    
}
