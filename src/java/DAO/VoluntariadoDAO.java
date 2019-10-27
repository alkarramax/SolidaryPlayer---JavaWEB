/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Voluntariado;

public interface VoluntariadoDAO {
    public void inserir(Voluntariado voluntariado);
    public void remover(int id);
    public List<Voluntariado> listar();
    public Voluntariado buscar(int id);
    public void editar(Voluntariado voluntariado);
}
