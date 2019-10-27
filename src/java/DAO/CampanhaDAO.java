/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Campanha;

public interface CampanhaDAO {
    public void inserir(Campanha campanha);
    public void remover(int id);
    public List<Campanha> listar();
    public Campanha buscar(int id);
    public void editar(Campanha campanha);
}
