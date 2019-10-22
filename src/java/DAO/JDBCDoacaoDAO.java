/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doacao;
import java.sql.*;

public class JDBCDoacaoDAO implements DoacaoDAO{

    Connection connection;

    public JDBCDoacaoDAO() throws SQLException, SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    
    @Override
    public void inserir(Doacao doacao) {
        try {
            String SQL = "insert into Entidade(Nome, Email, Causa, Telefone, Descricao, Endereco) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, doacao.getNome());
            ps.setString(2, doacao.getDescricao());
            //ps.setString(3, doacao.getJustificativa());
            ps.setString(4, doacao.getLocal());
            //ps.setString(5, doacao.getPublicoAlvo());
            //ps.setDate(6, (Date) doacao.getDataInicio());
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSoftplayerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Doacao> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doacao buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Doacao doacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
