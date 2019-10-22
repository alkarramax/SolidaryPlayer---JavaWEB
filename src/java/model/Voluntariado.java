package model;

public class Voluntariado {
    
    
    private int id_voluntariado;
    private String imagem;
    
    private int entidade_voluntariado_fk, softplayer_voluntariado_fk, necessidade_voluntariado_1_fk,
            necessidade_voluntariado_2_fk, necessidade_voluntariado_3_fk, necessidade_voluntariado_4_fk;
    
    private String nome, descricao, local;
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

    public int getEntidade_voluntariado_fk() {
        return entidade_voluntariado_fk;
    }

    public void setEntidade_voluntariado_fk(int entidade_voluntariado_fk) {
        this.entidade_voluntariado_fk = entidade_voluntariado_fk;
    }

    public int getSoftplayer_voluntariado_fk() {
        return softplayer_voluntariado_fk;
    }

    public void setSoftplayer_voluntariado_fk(int softplayer_voluntariado_fk) {
        this.softplayer_voluntariado_fk = softplayer_voluntariado_fk;
    }

    public int getNecessidade_voluntariado_1_fk() {
        return necessidade_voluntariado_1_fk;
    }

    public void setNecessidade_voluntariado_1_fk(int necessidade_voluntariado_1_fk) {
        this.necessidade_voluntariado_1_fk = necessidade_voluntariado_1_fk;
    }

    public int getNecessidade_voluntariado_2_fk() {
        return necessidade_voluntariado_2_fk;
    }

    public void setNecessidade_voluntariado_2_fk(int necessidade_voluntariado_2_fk) {
        this.necessidade_voluntariado_2_fk = necessidade_voluntariado_2_fk;
    }

    public int getNecessidade_voluntariado_3_fk() {
        return necessidade_voluntariado_3_fk;
    }

    public void setNecessidade_voluntariado_3_fk(int necessidade_voluntariado_3_fk) {
        this.necessidade_voluntariado_3_fk = necessidade_voluntariado_3_fk;
    }

    public int getNecessidade_voluntariado_4_fk() {
        return necessidade_voluntariado_4_fk;
    }

    public void setNecessidade_voluntariado_4_fk(int necessidade_voluntariado_4_fk) {
        this.necessidade_voluntariado_4_fk = necessidade_voluntariado_4_fk;
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
