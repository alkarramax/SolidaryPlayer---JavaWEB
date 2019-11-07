/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.JDBCVoluntariadoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Voluntariado;

@MultipartConfig(maxFileSize = 169999999)
public class cadastrarVoluntariado extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String data = request.getParameter("data");
            String hora = request.getParameter("hora");
            String descricao = request.getParameter("descricao");

            Part part = request.getPart("file");
            String fileName = extractFileName(part);
            String savePath = "C:\\Users\\Fiesc\\Documents\\NetBeansProjects\\SA1\\BackEndSolidaryPlayer\\web\\Home\\imageVoluntariado"+ File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);
            
            LocalDate dt = LocalDate.parse(data);
            LocalTime hr = LocalTime.parse(hora);
            
            Voluntariado voluntario = new Voluntariado();
            
            voluntario.setNome(nome);
            voluntario.setLocal(local);
            voluntario.setData(dt);
            voluntario.setHora(hr);
            voluntario.setDescricao(descricao);
            voluntario.setImagem(fileName);
            
            
            JDBCVoluntariadoDAO voluntariadoDAO = new JDBCVoluntariadoDAO();
            voluntariadoDAO.inserir(voluntario);
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Voluntariado Cadastrada!!');");
            out.println("location='/SA-JSP/Adm/Funcoes/addCampanha.jsp';");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cadastrarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(cadastrarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarVoluntariado.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
       
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
