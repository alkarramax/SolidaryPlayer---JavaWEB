/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.util.List;
import model.Campanha;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCCampanhaDAO implements CampanhaDAO{
    Connection connection;
    
    public JDBCCampanhaDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public void inserir(Campanha campanha) {
        try {
            String SQL = "insert into campanha(nome, descricao, path) "
                    + "values (?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, campanha.getNome());
                ps.setString(2, campanha.getDescricao());
                ps.setString(3, campanha.getImagem());

                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
        
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "Delete from campanha where id_campanhas= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public List<Campanha> listar() {
        List<Campanha> campanhas = new ArrayList<>();
        
        try {
            String SQL = "select * from campanhas";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Campanha campanha = new Campanha();

                campanha.setNome(rs.getString("nome"));
                campanha.setDescricao(rs.getString("descricao"));
                campanha.setLocal(rs.getString("local"));
                campanhas.add(campanha);
            }
            
        } catch (Exception e) {
            
        }
        return campanhas;
    }

    @Override
    public Campanha buscar(int id) {
        try {
            Campanha campanha = new Campanha();
            
            String sql = "Select * from campanha where nome = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            campanha.setNome(rs.getString("nome"));
            
            ps.close();
            rs.close();
            
            return campanha;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
    }

    @Override
    public void editar(Campanha campanha) {
        
    }
    
}
