/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entidade;


public class JDBCEntidadeDAO  {

    private List<Entidade> entidades = new ArrayList();
    private Entidade entidade;
    
    Connection connection;
    public JDBCEntidadeDAO() throws SQLException, ClassNotFoundException{
        connection = DBConnection.getConnection();
    }

    
    
    
    public void inserir(Entidade entidade) {
        try {
            String SQL = "INSERT INTO entidade(nome, email, causa, endereco, telefone, descricao, imagem) "
                    + "values (?,?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, entidade.getNome());
                ps.setString(2, entidade.getEmail());
                ps.setString(3, entidade.getCausa());
                ps.setString(4, entidade.getTelefone());
                ps.setString(5, entidade.getDescricao());
                ps.setString(6, entidade.getEndereco());
                ps.setString(7, entidade.getImagem());
                
                ps.executeUpdate();
                ps.close();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    }

   
    public void remover(int id) {
        try {
            String SQL = "Delete from entidade where id_entidade= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

   
    public List<Entidade> listar() {
        
        try {
            String sql = "select * from entidade";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            
            while(rs.next()) {
                entidade = new Entidade();
                
                entidade.setId_entidade(rs.getInt("id_entidade"));                
                entidade.setNome(rs.getString("nome"));
                entidade.setCausa(rs.getString("causa"));
                entidade.setDescricao(rs.getString("descricao"));
                entidade.setEmail(rs.getString("email"));
                entidade.setTelefone(rs.getString("telefone"));
                entidade.setImagem(rs.getString("imagem"));
            
                entidades.add(entidade);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCEntidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidades;
    }

    
    public Entidade buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void editar(Entidade softplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
