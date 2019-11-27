
package controller;

import DAO.JDBCSoftplayerDAO;
import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Softplayer;

public class CadastroSoftplayer extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            String unidade = request.getParameter("unidade");
           
            Connection connection = DBConnection.getConnection();
           
            String sql = "SELECT * FROM softplayer where email=?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                  if(email.equals(rs.getString("email"))) {
                      out.println("<script type=\"text/javascript\">");
                      out.println("alert('O E-mail já está cadastrado');");
                      out.println("location='/SA-JSP/Home/home.jsp';");
                      out.println("</script>");
                      return;
                  } 
            }
            
            String hashPassword = hashPassword(senha);
            
            Softplayer softplayer = new Softplayer();

            softplayer.setNome(nome);
            softplayer.setEmail(email);
            softplayer.setCargo(cargo);
            softplayer.setUnidade(unidade);
            softplayer.setSenha(hashPassword);

            JDBCSoftplayerDAO inserirDAO = new JDBCSoftplayerDAO();
            inserirDAO.inserir(softplayer);


            out.println("<script type=\"text/javascript\">");
            out.println("alert('Cadastro realizado com sucesso!!');");
            out.println("location='/SA-JSP/Home/home.jsp';");
            out.println("</script>");
        }
    }
    
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b1 : b) {
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        
        return sb.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
