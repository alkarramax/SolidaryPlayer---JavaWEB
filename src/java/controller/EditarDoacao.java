/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarDoacao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection connDoacao = DBConnection.getConnection();
            
            String id = request.getParameter("id_doacao");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String local = request.getParameter("local");
            String data = request.getParameter("data");

            if(nome != null && descricao != null && local != null && data != null) {
                String query = "update doacao set nome=?, descricao=?, local=?, data=? where id_doacao='"+id+"'";
                PreparedStatement stmt = connDoacao.prepareStatement(query);

                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setString(3, local);
                stmt.setString(4, data);
                stmt.executeUpdate();

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Doacao alterada!!');");
                out.println("location='/SA-JSP/Adm/administrador.jsp';");
                out.println("</script>");
                    
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
