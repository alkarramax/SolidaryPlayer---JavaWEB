
package controller;

import DAO.JDBCEntidadeDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Entidade;

@MultipartConfig(maxFileSize = 169999999)
public class cadastrarEntidade extends HttpServlet {
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
            String savePath = "C:\\Users\\Fiesc\\Documents\\NetBeansProjects\\SA1\\BackEndSolidaryPlayer\\web\\Home\\imageVoluntariado"+ File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);
            
            Entidade entidade = new Entidade();
            
            entidade.setNome(nome);
            entidade.setEmail(email);
            entidade.setCausa(causa);
            entidade.setEndereco(endereco);
            entidade.setTelefone(telefone);
            entidade.setDescricao(descricao);
            entidade.setImagem(fileName);
            
            JDBCEntidadeDAO inserirDAO = new JDBCEntidadeDAO();
            inserirDAO.inserir(entidade);
            
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Entidade Cadastrada!!');");
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
