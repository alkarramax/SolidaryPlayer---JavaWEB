
package model;

import java.time.LocalDate;

public class Doacao {
    
    private int id_doacao;
    private String nome, descricao, local, necessidade, imagem;

    private LocalDate data;
    private int quantidadeDeItens;
    private boolean aberta;
    
    private int id_softplayer;
    private int id_necessidade1;
    private int id_necessidade2;

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

    public int getId_necessidade1() {
        return id_necessidade1;
    }

    public void setId_necessidade1(int id_necessidade1) {
        this.id_necessidade1 = id_necessidade1;
    }

    public int getId_necessidade2() {
        return id_necessidade2;
    }

    public void setId_necessidade2(int id_necessidade2) {
        this.id_necessidade2 = id_necessidade2;
    }

   

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
}
