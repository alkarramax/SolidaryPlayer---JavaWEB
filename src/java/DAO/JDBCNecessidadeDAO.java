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
    
    private Necessidade necessidade = new Necessidade();
    List<Necessidade> necessidades = new ArrayList<>();
    List<Necessidade> descricoes = new ArrayList<>();
    
    Connection connection;
    
    public JDBCNecessidadeDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Necessidade necessidade) {
        try {
            String SQL = "INSERT INTO necessidade(descricao, unidade)"
                    + "values (?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, necessidade.getNecessidade());
                ps.setString(2, necessidade.getUnidade());
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
        
        }
    }

    public void remover(int id) {
        try {
            String SQL = "DELETE FROM necessidade WHERE id_necessidade= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public List<Necessidade> listar() {
        
        try {
            String SQL = "SELECT * FROM necessidade";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                necessidade = new Necessidade();
                
                necessidade.setId_necessidade(rs.getInt("id_necessidade"));
                necessidade.setNecessidade(rs.getString("descricao"));
                necessidade.setUnidade(rs.getString("unidade"));
              
                necessidades.add(necessidade);
            }
            
        } catch (Exception e) {
            
        }
        return necessidades;
    }

    public Necessidade buscar(int id) {
        try {
            necessidade = new Necessidade();
            
            String sql = "SELECT * FROM necessidade WHERE id_necessidade = '"+id+"'";
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public List<Necessidade> getDescricao(int id_campanha) {
        try {
            String sql = "select necessidade.descricao, necessidade.unidade, necessidade.id_necessidade from necessidade inner join campanha on campanha.id_necessidade = necessidade.id_necessidade where campanha.id_campanha = '"+id_campanha+"'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                necessidade = new Necessidade();
                
                necessidade.setNecessidade(rs.getString("descricao"));
                necessidade.setId_necessidade(rs.getInt("id_necessidade"));
                necessidade.setUnidade(rs.getString("unidade"));
                descricoes.add(necessidade);
            }
            
            
        } catch (Exception e) {
        
        }
        
        return descricoes;
    }
     
}
