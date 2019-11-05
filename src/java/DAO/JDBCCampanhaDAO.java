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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCCampanhaDAO {
    private List<Campanha> campanhas = new ArrayList<>();
    private Campanha campanha;
    Connection connection;
    
    public JDBCCampanhaDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Campanha campanha) {
        try {
            String SQL = "INSERT INTO campanha(nome, local, dataInicio, dataTermino, descricao, imagem)"
                    + "values (?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, campanha.getNome());
                ps.setString(2, campanha.getLocal());
                ps.setString(3, String.valueOf(campanha.getDataInicio()));
                ps.setString(4, String.valueOf(campanha.getDataTermino()));
                ps.setString(5, campanha.getDescricao());
                ps.setString(6, campanha.getImagem());
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
        
        }
    }

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

    public List<Campanha> listar() {
        
        
        try {
            String SQL = "select * from campanha";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                campanha = new Campanha();
                
                campanha.setId_campanha(rs.getInt("id_campanha"));
                campanha.setId_softplayer(rs.getInt("id_softplayer"));
                campanha.setId_necessidade(rs.getInt("id_necessidade"));
                
                campanha.setNome(rs.getString("nome"));
                campanha.setLocal(rs.getString("local"));
                
                String dataInicio = rs.getDate("dataInicio").toString();
                LocalDate dtInicio = LocalDate.parse(dataInicio);
                campanha.setDataInicio(dtInicio);
                
                String dataTermino = rs.getDate("dataTermino").toString();
                LocalDate dtTermino = LocalDate.parse(dataTermino);
                campanha.setDataTermino(dtTermino);
                
                campanha.setDescricao(rs.getString("descricao"));
                campanha.setImagem(rs.getString("imagem"));

                campanhas.add(campanha);
            }
            
        } catch (Exception e) {
            
        }
        return campanhas;
    }

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

    public void editar(Campanha campanha) {
        
    }
    
}
