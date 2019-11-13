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

public class JDBCCampanhaDAO{
    private List<Doacao> doacoes = new ArrayList<>();
    private Doacao doacao;
    Connection connection;

    public JDBCCampanhaDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    
    public void inserir(Doacao doacao) {
        try {
            String SQL = "insert into doacao(id_softplayer, id_necessidade1, id_necessidade2, nome, descricao, local, imagem, data, aberta) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, doacao.getNome());
            ps.setString(2, doacao.getDescricao());
            ps.setString(3, doacao.getLocal());  
            ps.setString(4, String.valueOf(doacao.getData()));
            doacao.setAberta(true);
            ps.setBoolean(5, doacao.isAberta());
            ps.setInt(6, doacao.getId_softplayer());
            ps.setInt(7, doacao.getId_necessidade1());
            ps.setInt(8, doacao.getId_necessidade2());
            ps.setString(9, doacao.getImagem());
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro no cadastro da Campanha!");
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
            String SQL = "select * from doacao";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                doacao = new Doacao();
                
                doacao.setId_doacao(rs.getInt("id_cam"
                        + "panha"));
                doacao.setId_softplayer(rs.getInt("id_softplayer"));
                doacao.setId_necessidade1(rs.getInt("id_necessidade1"));
                doacao.setId_necessidade2(rs.getInt("id_necessidade2"));
                
                doacao.setNome(rs.getString("nome"));
                doacao.setDescricao(rs.getString("descricao"));
                doacao.setLocal(rs.getString("local"));
                doacao.setImagem(rs.getString("imagem"));
                
                
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
