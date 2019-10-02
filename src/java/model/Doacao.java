
package model;

import java.util.Date;

public class Doacao {
    
    private long id;
    private String nome, descricao, justificativa, local, publicoAlvo;
    
    private Date dataInicio, dataTermino;
    
    private String item;
    private boolean aberta; 
    
    private Entidade entidade;
    private Softplayer softplayer;
}
