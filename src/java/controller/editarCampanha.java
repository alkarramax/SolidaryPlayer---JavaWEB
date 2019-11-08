/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.DBConnection;
import java.io.*;
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
public class editarCampanha extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection connCampanha = DBConnection.getConnection();
            
            String id = request.getParameter("id_campanha");
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String dataInicio = request.getParameter("dataInicio");
            String dataTermino = request.getParameter("dataTermino");
            String descricao = request.getParameter("descricao");
            
            if(nome != null && local != null && dataInicio != null && dataTermino != null && descricao != null) {
                String query = "update campanha set nome=?, local=?, dataInicio=?, dataTermino=?, descricao=? where id_campanha='"+id+"'";
                PreparedStatement stmt = connCampanha.prepareStatement(query);

                stmt.setString(1, nome);
                stmt.setString(2, local);
                stmt.setString(3, dataInicio);
                stmt.setString(4, dataTermino);
                stmt.setString(5, descricao);
                stmt.executeUpdate();

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Campanha alterada!!');");
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
            Logger.getLogger(editarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(editarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
