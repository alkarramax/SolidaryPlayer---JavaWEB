/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CampanhaDAO;
import DB.DAOFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Campanha;

@MultipartConfig(maxFileSize = 169999999)
public class criarCampanha extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String local = request.getParameter("local");
            String dataInicio = request.getParameter("dataInicio");
            String dataTermino = request.getParameter("dataTermino");
            String descricao = request.getParameter("descricao");
            
            
            Part part = request.getPart("file");
            String fileName = extractFileName(part);
            String savePath = "C:\\Users\\Aluno\\Documents\\NetBeansProjects\\BackEndSolidaryPlayer\\web\\Home\\imageCampanha"+ File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);
            
            LocalDate dtInicio = LocalDate.parse(dataInicio);
            LocalDate dtTermino = LocalDate.parse(dataTermino);
            
            Campanha campanha = new Campanha();
            
            campanha.setNome(nome);
            campanha.setLocal(local);
            campanha.setDataInicio(dtInicio);
            campanha.setDataTermino(dtTermino);
            campanha.setDescricao(descricao);
            campanha.setImagem(fileName);
            
            CampanhaDAO cp = DAOFactory.createCampanhaDAO();
            cp.inserir(campanha);
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Campanha Cadastrada!!');");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(cadastrarEntidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}

