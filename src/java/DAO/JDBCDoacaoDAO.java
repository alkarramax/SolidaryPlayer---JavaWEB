
package DAO;
import DB.DBConnection;
import java.sql.*;
import model.Doacao;

public class JDBCDoacaoDAO {
    
    Connection connection;
    
    public JDBCDoacaoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Doacao doacao) throws SQLException {
        try {
        String sql = "INSERT INTO doacao(id_softplayer, id_campanha, quantidade_doada)"
                + "values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setInt(1, doacao.getId_softplayer());
        ps.setInt(2, doacao.getId_campanha());
        ps.setInt(1, doacao.getQuantidadeDoada());
        ps.executeUpdate();
        ps.close();
            
        } catch (Exception e) {
            System.out.println("Erro no cadastro da Doacao!");
        }
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
