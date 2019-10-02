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
            String SQL = "insert into softplayer(nome, sobrenome, senha, email, cargo, unidade) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, softplayer.getNome());
            ps.setString(2, softplayer.getSobrenome());
            ps.setString(3, softplayer.getSenha());
            ps.setString(4, softplayer.getEmail());
            ps.setString(5, softplayer.getCargo());
            ps.setString(6, softplayer.getUnidade());
            
            ps.executeUpdate();
            
            
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
                
                softplayer.setUuid(rs.getInt("id"));
                softplayer.setNome(rs.getString("nome"));
                softplayer.setSobrenome(rs.getString("sobrenome"));
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
    public Softplayer buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Softplayer softplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
