/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.util.List;
import model.Softplayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCSoftplayerDAO implements SoftplayerDAO {

    Connection connection;
    public JDBCSoftplayerDAO() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    
    
    @Override
    public void inserir(Softplayer softplayer) {
        try {
            String SQL = "insert into softplayers(nome, senha, email, cargo, unidade) "
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, softplayer.getNome());
            ps.setString(2, softplayer.getSenha());
            ps.setString(3, softplayer.getEmail());
            ps.setString(4, softplayer.getCargo());
            ps.setString(5, softplayer.getUnidade());
            
            ps.executeUpdate();
            
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
               
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "Delete from softplayer where id= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public List<Softplayer> listar() {
        List<Softplayer> softplayers = new ArrayList<>();
        
        try {
            String SQL = "select * from softplayer";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Softplayer softplayer = new Softplayer();
                
                //softplayer.setUuid(rs.getInt("id"));
                softplayer.setNome(rs.getString("nome"));
                softplayer.setEmail(rs.getString("email"));
                softplayer.setCargo(rs.getString("cargo"));
                softplayer.setUnidade(rs.getString("unidade"));
                softplayers.add(softplayer);
            }
            
        } catch (Exception e) {
            
        }
        return softplayers;
    }

    @Override
    public Softplayer buscar(String email) { 
        try {
            Softplayer softplayer = new Softplayer();
            
            String sql = "Select * from softplayer where email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            softplayer.setNome(rs.getString("nome"));
            
            ps.close();
            rs.close();
            
            return softplayer;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
        
    }

    @Override
    public void editar(Softplayer softplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
