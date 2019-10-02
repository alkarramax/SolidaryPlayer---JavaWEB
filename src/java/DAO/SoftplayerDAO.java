/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Softplayer;

public interface SoftplayerDAO {
    public void inserir(Softplayer softplayer);
    public void remover(int id);
    public List<Softplayer> listar();
    public Softplayer buscar(int id);
    public void editar(Softplayer softplayer);
    
}
