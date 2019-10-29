/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CampanhaDAO;
import DAO.EntidadeDAO;
import DB.DAOFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Campanha;
import model.Entidade;

/**
 *
 * @author Aluno
 */
public class cadastrarCampanha extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String causa = request.getParameter("causa");
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String descricao = request.getParameter("descricao");
            
            Part part = request.getPart("file");
            String fileName = extractFileName(part);
            String savePath = "C:\\Users\\Aluno\\Documents\\NetBeansProjects\\BackEndSolidaryPlayerAaa\\web\\Home\\imageEntidade"+ File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);
            
            Campanha campanha = new Campanha();
            
            campanha.setNome(nome);
            campanha.setDescricao(descricao);
            campanha.setImagem(fileName);
            
            CampanhaDAO et = DAOFactory.createCampanhaDAO();
            et.inserir(campanha);
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Campanha Cadastrada!!');");
            out.println("location='/SA-JSP/Adm/Funcoes/addEntidades.jsp';");
            out.println("</script>");
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
         String[] items = contentDisp.split(";");
         for(String s : items ) {
             if(s.trim().startsWith("filename")) {
                 return s.substring(s.indexOf("=") + 2, s.length() - 1);
             }
         }
         return "";
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
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
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
