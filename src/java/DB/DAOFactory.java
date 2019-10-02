/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DAO.EntidadeDAO;
import DAO.JDBCEntidadeDAO;
import DAO.JDBCSoftplayerDAO;
import DAO.SoftplayerDAO;
import java.sql.SQLException;

public class DAOFactory {
    public static SoftplayerDAO createSoftplayerDAO() throws SQLException, ClassNotFoundException {
        
        return new JDBCSoftplayerDAO();
    }
    
    public static EntidadeDAO createEntidadeDAO() throws SQLException, ClassNotFoundException {
        
        return new JDBCEntidadeDAO();
    }
    
    
}
