/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.JDBCDoacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doacao;

public class Doar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String id = request.getParameter("id_campanha");
            String quantidade = request.getParameter("quantidadeDoada");
            
            int id_campanha = Integer.parseInt(id);
            int id_softplayer = (Integer) session.getAttribute("id");
            int quantidadeDoada = Integer.parseInt(quantidade);
            
            Doacao doacao = new Doacao();
            
            doacao.setId_softplayer(id_softplayer);
            doacao.setId_campanha(id_campanha);
            doacao.setQuantidadeDoada(quantidadeDoada);
            
            JDBCDoacaoDAO doacaoDAO = new JDBCDoacaoDAO();
            doacaoDAO.inserir(doacao);
            
            JDBCDoacaoDAO antigoValor = new JDBCDoacaoDAO();
            int valorA = antigoValor.getQuantidadeAntiga(id_campanha);
            
            int newV = valorA + quantidadeDoada;
            
            JDBCDoacaoDAO newValor = new JDBCDoacaoDAO();
            newValor.setQuantidadeNova(newV, id_campanha, id_softplayer);
         
                
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Doação realizada com successful!!');");
            out.println("location='/SA-JSP/Home/home.jsp';");
            out.println("</script>");
            
            }
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Doar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Doar.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Doar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Doar.class.getName()).log(Level.SEVERE, null, ex);
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
