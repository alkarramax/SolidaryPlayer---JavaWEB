package DAO;

import DB.DBConnection;
import java.util.List;
import model.Softplayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCSoftplayerDAO {
    
    private List<Softplayer> softplayers = new ArrayList<>();
    private Softplayer softplayer = new Softplayer();
    Connection connection;
    public JDBCSoftplayerDAO() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    
    
    public void inserir(Softplayer softplayer) {
        try {
            String SQL = "INSERT INTO softplayer(nome, email, cargo, unidade, senha)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, softplayer.getNome());
            ps.setString(2, softplayer.getEmail());
            ps.setString(3, softplayer.getCargo());
            ps.setString(4, softplayer.getUnidade());
            ps.setString(5, softplayer.getSenha());
            
            ps.executeUpdate();
            ps.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
               
    }

    public void remover(int id) {
        try {
            String SQL = "delete from softplayer where id_softplayer= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public List<Softplayer> listar() {

        try {
            String SQL = "select * from softplayer";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                softplayer = new Softplayer();
                
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

    public Softplayer buscar(String email) { 
        try {
            String sql = "Select from softplayer where email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
            
            return softplayer;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
        
    }

    public void editar(Softplayer softplayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
