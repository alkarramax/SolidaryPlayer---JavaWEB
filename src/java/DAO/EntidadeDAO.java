/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Entidade;

public interface EntidadeDAO {
    public void inserir(Entidade entidade);
    public void remover(int id);
    public List<Entidade> listar();
    public Entidade buscar(int id);
    public void editar(Entidade entidade);
}
