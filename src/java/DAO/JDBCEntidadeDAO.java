/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entidade;


public class JDBCEntidadeDAO implements EntidadeDAO {

    Connection connection;
    public JDBCEntidadeDAO() throws SQLException, ClassNotFoundException{
        connection = DBConnection.getConnection();
    }

    
    
    @Override
    public void inserir(Entidade entidade) {
        try {
            String SQL = "insert into Entidade(Nome, Email, Causa, Telefone, Descricao, Endereco, imagem) "
                    + "values (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, entidade.getNome());
                ps.setString(2, entidade.getEmail());
                ps.setString(3, entidade.getCausa());
                ps.setString(4, entidade.getTelefone());
                ps.setString(5, entidade.getDescricao());
                ps.setString(6, entidade.getEndereco());
                ps.setBlob(7, entidade.getPhoto());
                
                ps.executeUpdate();
                ps.close();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "Delete from entidade where id= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public List<Entidade> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidade buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Entidade softplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
