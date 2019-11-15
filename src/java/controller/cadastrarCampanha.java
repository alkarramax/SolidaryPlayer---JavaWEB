package controller;

import DAO.JDBCCampanhaDAO;
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
public class cadastrarCampanha extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String necessidade1 = request.getParameter("necessidade1");
            String necessidade2 = request.getParameter("necessidade2");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String local = request.getParameter("local");
            String data = request.getParameter("data");
           
            LocalDate dt = LocalDate.parse(data);
            int id_necessidade1 = Integer.parseInt(necessidade1);
            int id_necessidade2 = Integer.parseInt(necessidade2);
            
            Part part = request.getPart("file");
            String fileName = extractFileName(part);
            String savePath = "C:\\Users\\alkar\\Desktop\\Programação\\JAVA\\Softplayer\\BackEndSolidaryPlayer\\web\\Home\\imageCampanha"+ File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);
            
            Campanha campanha = new Campanha();

            campanha.setNome(nome);
            campanha.setDescricao(descricao);
            campanha.setLocal(local);
            campanha.setData(dt);
            campanha.setImagem(fileName);
            campanha.setId_necessidade1(id_necessidade1);
            campanha.setId_necessidade2(id_necessidade2);
            
            JDBCCampanhaDAO campanhaDAO = new JDBCCampanhaDAO();
            campanhaDAO.inserir(campanha);

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Campanha Cadastrada!!');");
            out.println("location='/SA-JSP/Adm/Funcoes/cadastrarCampanha.jsp';");
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
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastrarCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
       
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
