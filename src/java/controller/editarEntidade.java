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
public class editarEntidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection connEntidade = DBConnection.getConnection();
            
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String causa = request.getParameter("causa");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String descricao = request.getParameter("descricao");

            if(nome != null && email != null && causa != null && endereco != null && telefone != null && descricao != null) {
                String query = "update entidade set nome=?, email=?, causa=?, endereco=?, telefone=?, descricao=? where id='"+id+"'";
                PreparedStatement stmt = connEntidade.prepareStatement(query);

                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setString(3, causa);
                stmt.setString(4, endereco);
                stmt.setString(5, telefone);
                stmt.setString(6, descricao);
                stmt.executeUpdate();

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Entidade alterada!!');");
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
            Logger.getLogger(editarEntidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarEntidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(editarEntidade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editarEntidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
