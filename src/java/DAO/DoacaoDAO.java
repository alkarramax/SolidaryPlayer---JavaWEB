/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Doacao;


public interface DoacaoDAO {
    public void inserir(Doacao doacao);
    public void remover(int id);
    public List<Doacao> listar();
    public Doacao buscar(int id);
    public void editar(Doacao doacao);
}
