
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



public class JDBCVoluntariadoDAO {
    private List<Voluntariado> voluntariados = new ArrayList<>();
    private Voluntariado voluntariado;
    Connection connection;
    
    public JDBCVoluntariadoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void inserir(Voluntariado voluntariado) {
       try {
            String SQL = "INSERT INTO voluntariado(nome, local, data, hora, descricao, imagem)"
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

    public List<Voluntariado> listar() {
        try {
            String SQL = "select * from voluntariado";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                voluntariado = new Voluntariado();

                voluntariado.setId_voluntariado(rs.getInt("id_voluntariado"));
                voluntariado.setNome(rs.getString("nome"));
                voluntariado.setLocal(rs.getString("local"));
                
                String data = rs.getDate("data").toString();
                LocalDate dt = LocalDate.parse(data);
                voluntariado.setData(dt);
                
                String hora = rs.getTime("hora").toString();
                LocalTime hr = LocalTime.parse(hora);
                voluntariado.setHora(hr);
                
                voluntariado.setDescricao(rs.getString("descricao"));
                voluntariado.setImagem(rs.getString("imagem"));
                
                voluntariados.add(voluntariado);
            }
            
        } catch (Exception e) {
            
        }
        return voluntariados;
    }

    public Voluntariado buscar(int id) {
        try {
            voluntariado = new Voluntariado();
            
            String sql = "Select * from voluntariado where id_voluntariado = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            voluntariado.setId_voluntariado(rs.getInt("id_voluntariado"));
            
            ps.close();
            rs.close();
            
            return voluntariado;
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCVoluntariadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro", ex);
        }
    }

    public void editar(Voluntariado voluntariado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
