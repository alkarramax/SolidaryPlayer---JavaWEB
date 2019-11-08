package DAO;

import DB.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doacao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JDBCDoacaoDAO{
    private List<Doacao> doacoes = new ArrayList<>();
    private Doacao doacao;
    Connection connection;

    public JDBCDoacaoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    
    public void inserir(Doacao doacao) {
        try {
            String SQL = "insert into doacao(nome, descricao, local,  data, aberta) "
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, doacao.getNome());
            ps.setString(2, doacao.getDescricao());
            ps.setString(3, doacao.getLocal());  
            ps.setString(4, String.valueOf(doacao.getData()));
            doacao.setAberta(true);
            ps.setBoolean(5, doacao.isAberta());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(int id) {
        try {
            String SQL = "delete from doacao where id_doacao= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    public List<Doacao> listar() throws SQLException {
        try {
            String SQL = "select * from campanha";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                doacao = new Doacao();
                
                doacao.setId_doacao(rs.getInt("id_doacao"));
                doacao.setId_softplayer(rs.getInt("id_softplayer"));
                doacao.setId_necessidade(rs.getInt("id_necessidade"));
                doacao.setId_entidade(rs.getInt("id_entidade"));
                
                doacao.setNome(rs.getString("nome"));
                doacao.setDescricao(rs.getString("descricao"));
                doacao.setLocal(rs.getString("local"));
                
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                doacao.setData(dt);
                
                doacoes.add(doacao);
            }
        }catch(SQLException e){
            
        }
        return doacoes;
    }

    public Doacao buscar(int id) {
        try {
            Doacao doacao = new Doacao();
            
            String sql = "Select * from doacao where nome = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            doacao.setNome(rs.getString("nome"));
            
            ps.close();
            rs.close();
            
            return doacao;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
    }

    public void editar(Doacao doacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
