package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Softplayer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JDBCSoftplayerDAOTest {
    
    Softplayer s;
    JDBCSoftplayerDAO sDAO;
    
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        s = new Softplayer();
        s.setNome("João");
        s.setEmail("joao@gmail.com");
        s.setCargo("Coordenador");
        s.setUnidade("Justiça");
        s.setSenha("123321");
        sDAO = new JDBCSoftplayerDAO();
    }
    
    @Test
    public void testInserir() {
        sDAO.inserir(s);
    }

    @Test
    public void testRemover() {
        sDAO.remover(11);
    }

    @Test
    public void testListar() {
        sDAO.listar();
    }

    @Test
    public void testBuscar() {
        sDAO.buscar("joao@gmail.com");
    }

    @Test
    public void testEditar() {
        sDAO.editar(s);
    }
    
}
