
package DAO;
import DB.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Doacao;

public class JDBCDoacaoDAO {
    
    private Doacao doacao = new Doacao();
    private List<Doacao> doacoes = new ArrayList<>();
    
    Connection connection;
    
    public JDBCDoacaoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Doacao doacao) throws SQLException {
        try {
        String sql = "INSERT INTO doacao(softplayer_id, campanha_id, quantidade_doada, necessidade_id)"
                + "values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
         
        ps.setInt(1, doacao.getId_softplayer());
        ps.setInt(2, doacao.getId_campanha());
        ps.setInt(3, doacao.getQuantidadeDoada());
        ps.setInt(4, doacao.getNecessidade_id());
        ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Erro no cadastro da Doacao!");
        }
    }
    
    public List<Doacao> listarDoadores(int id_campanha) {
         try {
            String SQL = "SELECT doacao.campanha_id, doacao.quantidade_doada, softplayer.nome \n" +
                        "FROM doacao \n" +
                        "INNER JOIN campanha \n" +
                        "ON campanha.id_campanha = doacao.campanha_id\n" +
                        "INNER JOIN softplayer\n" +
                        "ON softplayer.id_softplayer = doacao.softplayer_id WHERE campanha.id_campanha ='"+id_campanha+"'";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()) {
                doacao = new Doacao();
               
                doacao.setId_campanha(rs.getInt("campanha_id"));
                doacao.setId_softplayer(rs.getInt("softplayer_id"));
                doacao.setQuantidadeDoada(rs.getInt("quantidade_doada"));
                doacao.setNecessidade_id(rs.getInt("necessidade_id"));
                
                doacoes.add(doacao);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar as campanhas!");
        }
        return doacoes;
    }
    
    public List<Doacao> lista(Doacao doacao) {
        try {
            String SQL = "select * from doacao";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()) {
                doacao = new Doacao();
               
                doacao.setId_campanha(rs.getInt("campanha_id"));
                doacao.setId_softplayer(rs.getInt("softplayer_id"));
                doacao.setQuantidadeDoada(rs.getInt("quantidade_doada"));
                doacao.setNecessidade_id(rs.getInt("necessidade_id"));
                
                doacoes.add(doacao);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar as campanhas!");
        }
        return doacoes;
    }
    
    public int getQuantidadeAntiga(int id_camp) throws SQLException{
        String sql = "select quantidade_doada from doacao where id_campanha='"+id_camp+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        
        int valor = 0;
        
        while(rs.next()){
            valor = rs.getInt("quantidade_doada");
        }
        return valor;
    }
    
    public void setQuantidadeNova(int newValor, int id_campanha, int idUser) throws SQLException{
        String sql = "update doacao set id_softplayer='"+idUser+"', quantidade_doada='"+newValor+"' where id_campanha='"+id_campanha+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.executeUpdate();
    }
}
