
package model;

import java.time.LocalDate;

public class Doacao {
    
    private int id_doacao;
    private String nome, descricao, local, necessidade;
    private LocalDate data;
    private int quantidadeDeItens;
    private boolean aberta;
    
    private int id_softplayer;
    private int id_necessidade;
    private int id_entidade;

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
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

    public String getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public int getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public void setQuantidadeDeItens(int quantidadeDeItens) {
        this.quantidadeDeItens = quantidadeDeItens;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public int getId_softplayer() {
        return id_softplayer;
    }

    public void setId_softplayer(int id_softplayer) {
        this.id_softplayer = id_softplayer;
    }

    public int getId_necessidade() {
        return id_necessidade;
    }

    public void setId_necessidade(int id_necessidade) {
        this.id_necessidade = id_necessidade;
    }

    public int getId_entidade() {
        return id_entidade;
    }

    public void setId_entidade(int id_entidade) {
        this.id_entidade = id_entidade;
    }
    
    
}
