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

/**
 *
 * @author Aluno
 */
public class editarVoluntariado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection connVoluntariado = DBConnection.getConnection();
            
            String id = request.getParameter("id_voluntariado");
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String data = request.getParameter("data");
            String hora = request.getParameter("hora");
            String descricao = request.getParameter("descricao");
            String imagem = request.getParameter("imagem");

            if(nome != null && local != null && data != null && hora != null && descricao != null && imagem != null) {
                String query = "update voluntariado set nome=?, local=?, data=?, hora=?, descricao=?, imagem=? where id_voluntariado='"+id+"'";
                PreparedStatement stmt = connVoluntariado.prepareStatement(query);

                stmt.setString(1, nome);
                stmt.setString(2, local);
                stmt.setString(3, data);
                stmt.setString(4, hora);
                stmt.setString(5, descricao);
                stmt.setString(6, imagem);
                stmt.executeUpdate();

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Voluntariado alterada!!');");
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
            Logger.getLogger(editarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(editarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
