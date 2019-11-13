package controller;

import DAO.JDBCCampanhaDAO;
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
import model.Doacao;

@MultipartConfig(maxFileSize = 169999999)
public class CadastrarDoacao extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String local = request.getParameter("local");
            String data = request.getParameter("data");
            
            LocalDate dt = LocalDate.parse(data);
            
            Doacao doacao = new Doacao();

            doacao.setNome(nome);
            doacao.setDescricao(descricao);
            doacao.setLocal(local);
            doacao.setData(dt);
            
            JDBCCampanhaDAO doacaoDAO = new JDBCCampanhaDAO();
            doacaoDAO.inserir(doacao);

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Doação Cadastrada!!');");
            out.println("location='/SA-JSP/Adm/Funcoes/addDoacao.jsp';");
            out.println("</script>");
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
       
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
