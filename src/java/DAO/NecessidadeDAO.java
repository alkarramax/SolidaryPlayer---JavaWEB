/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Necessidade;

public interface NecessidadeDAO {
    public void inserir(Necessidade necessidade);
    public void remover(int id);
    public List<Necessidade> listar();
    public Necessidade buscar(int id);
    public void editar(Necessidade necessidade);
}
