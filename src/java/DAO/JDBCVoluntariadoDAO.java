
package DAO;

import DB.DBConnection;
import java.util.List;
import model.Voluntariado;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JDBCVoluntariadoDAO implements VoluntariadoDAO{

    Connection connection;
    
    public JDBCVoluntariadoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    @Override
    public void inserir(Voluntariado voluntariado) {
       try {
            String SQL = "insert into voluntariado(nome, local, data, hora, descricao, imagem)"
                    + "values (?,?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, voluntariado.getNome());
                ps.setString(2, voluntariado.getLocal());
                ps.setString(3, String.valueOf(voluntariado.getData()));
                ps.setString(4, String.valueOf(voluntariado.getHora()));
                ps.setString(5, voluntariado.getDescricao());
                ps.setString(6, voluntariado.getImagem());
                
                
                ps.executeUpdate();
                ps.close();
            }
        } catch (Exception e) {
        
        }
    }

    @Override
    public void remover(int id) {
        try {
            String SQL = "Delete from voluntario where id_voluntario= ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public List<Voluntariado> listar() {
        List<Voluntariado> voluntariados = new ArrayList<>();
        
        try {
            String SQL = "select * from voluntario";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Voluntariado voluntariado = new Voluntariado();

                voluntariado.setNome(rs.getString("nome"));
                voluntariado.setLocal(rs.getString("local"));
                
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                voluntariado.setData(dt);
                
                String hora = rs.getTime("hora").toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                //voluntariado.setHora();
                
                voluntariados.add(voluntariado);
            }
            
        } catch (Exception e) {
            
        }
        return voluntariados;
    }

    @Override
    public Voluntariado buscar(int id) {
        try {
            Voluntariado voluntariado = new Voluntariado();
            
            String sql = "Select * from voluntario where nome = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            voluntariado.setNome(rs.getString("nome"));
            
            ps.close();
            rs.close();
            
            return voluntariado;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVoluntariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
    }

    @Override
    public void editar(Voluntariado voluntariado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
