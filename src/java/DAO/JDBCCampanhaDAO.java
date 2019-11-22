package DAO;

import DB.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Campanha;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JDBCCampanhaDAO{
    private List<Campanha> campanhas = new ArrayList<>();
    private Campanha campanha;
    Connection connection;

    public JDBCCampanhaDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
   
   
    public void inserir(Campanha campanha) {
        try {
            String SQL = "insert into campanha(nome, descricao, local, data, imagem, beneficiario, aberta, id_necessidade1, id_necessidade2) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            
            ps.setString(1, campanha.getNome());
            ps.setString(2, campanha.getDescricao());
            ps.setString(3, campanha.getLocal());  
            ps.setString(4, String.valueOf(campanha.getData()));
            campanha.setAberta(true);
            ps.setString(5, campanha.getImagem());
            ps.setString(6, campanha.getBeneficiario());
            ps.setBoolean(7, campanha.isAberta());
            ps.setInt(8, campanha.getId_necessidade1());
            ps.setInt(9, campanha.getId_necessidade2());
            ps.executeUpdate();
            ps.close();
           
        } catch (SQLException ex) {
            System.out.println("Erro no cadastro da Campanha!");
        }
    }

    public void remover(int id) {
        try {
            String SQL = "delete from campanha where id_campanha= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
           
        } catch (Exception e) {
            System.out.println("Erro ao remover a campanha!");
        }
    }

    public List<Campanha> listar() throws SQLException {
        try {
            String SQL = "select * from campanha";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()) {
                campanha = new Campanha();
               
                campanha.setId_campanha(rs.getInt("id_campanha"));
                campanha.setId_necessidade1(rs.getInt("id_necessidade1"));
                campanha.setId_necessidade2(rs.getInt("id_necessidade2"));
               
                campanha.setNome(rs.getString("nome"));
                campanha.setDescricao(rs.getString("descricao"));
                campanha.setLocal(rs.getString("local"));
                campanha.setImagem(rs.getString("imagem"));
               
               /*
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                campanha.setData(dt);
               */
                campanhas.add(campanha);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar as campanhas!");
        }
        return campanhas;
    }

    public List<Campanha> listarCrianca() throws SQLException {
        try {
            String SQL = "select * from campanha where beneficiario = 'crianca'";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()) {
                campanha = new Campanha();
               
                campanha.setId_campanha(rs.getInt("id_campanha"));
                campanha.setId_necessidade1(rs.getInt("id_necessidade1"));
                campanha.setId_necessidade2(rs.getInt("id_necessidade2"));
               
                campanha.setNome(rs.getString("nome"));
                campanha.setDescricao(rs.getString("descricao"));
                campanha.setLocal(rs.getString("local"));
                campanha.setImagem(rs.getString("imagem"));
               
               /*
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                campanha.setData(dt);
               */
                campanhas.add(campanha);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar as campanhas!");
        }
        return campanhas;
    }
    
    public List<Campanha> listarIdosos() throws SQLException {
        try {
            String SQL = "select * from campanha where beneficiario='idoso'";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()) {
                campanha = new Campanha();
               
                campanha.setId_campanha(rs.getInt("id_campanha"));
                campanha.setId_necessidade1(rs.getInt("id_necessidade1"));
                campanha.setId_necessidade2(rs.getInt("id_necessidade2"));
               
                campanha.setNome(rs.getString("nome"));
                campanha.setDescricao(rs.getString("descricao"));
                campanha.setLocal(rs.getString("local"));
                campanha.setImagem(rs.getString("imagem"));
               
               /*
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                campanha.setData(dt);
               */
                campanhas.add(campanha);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar as campanhas!");
        }
        return campanhas;
    }

    public Campanha buscar(int id) {
        try {
            campanha = new Campanha();
           
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
            throw new RuntimeException("Erro ao buscar a campanha!", ex);
        }
    }
    
    public int getQuantidadeAntiga(int id_camp) throws SQLException{
        String sql = "select quantidade_doada from campanha where id_campanha='"+id_camp+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        
        int valor = 0;
        
        while(rs.next()){
            valor = rs.getInt("quantidade_doada");
        }
        return valor;
    }
    
    public void setQuantidadeNova(int newValor, int id_campanha, int idUser) throws SQLException{
        String sql = "update campanha set id_softplayer='"+idUser+"' , quantidade_doada='"+newValor+"' where id_campanha='"+id_campanha+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        
        ps.executeUpdate();
    }

}
