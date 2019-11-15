/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.sql.SQLException;
import java.util.List;
import model.Necessidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCNecessidadeDAO {
    
    Connection connection;
    
    public JDBCNecessidadeDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Necessidade necessidade) {
        try {
            String SQL = "insert into Necessidade(descricao)"
                    + "values (?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, necessidade.getNecessidade());
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
        
        }
    }

    public void remover(int id) {
        try {
            String SQL = "Delete from necessidade where id_necessidade= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public List<Necessidade> listar() {
        List<Necessidade> necessidades = new ArrayList<>();
        
        try {
            String SQL = "select * from necessidade";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Necessidade necessidade = new Necessidade();
                
                necessidade.setId_necessidade(rs.getInt("id_necessidade"));
                necessidade.setNecessidade(rs.getString("descricao"));
              
                necessidades.add(necessidade);
            }
            
        } catch (Exception e) {
            
        }
        return necessidades;
    }

    public Necessidade buscar(int id) {
        try {
            Necessidade necessidade = new Necessidade();
            
            String sql = "Select * from necessidade where necessidade = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            necessidade.setNecessidade(rs.getString("descricao"));
            
            ps.close();
            rs.close();
            
            return necessidade;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
    }

    public void editar(Necessidade necessidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
