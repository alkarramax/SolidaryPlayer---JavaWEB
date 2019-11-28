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
import javax.servlet.RequestDispatcher;
import model.Doacao;

public class Doar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String id = request.getParameter("id_campanha");
            String id1 = request.getParameter("necessidade_id");
            String quantidade = request.getParameter("quantidadeDoada");
            
            int id_campanha = Integer.parseInt(id);
            int id_softplayer = (Integer) session.getAttribute("id");
            int quantidadeDoada = Integer.parseInt(quantidade);
            int necessidade_id = Integer.parseInt(id1);
            
            Doacao doacao = new Doacao();
            
            doacao.setId_softplayer(id_softplayer);
            doacao.setId_campanha(id_campanha);
            doacao.setQuantidadeDoada(quantidadeDoada);
            doacao.setNecessidade_id(necessidade_id);
            
            JDBCDoacaoDAO doacaoDAO = new JDBCDoacaoDAO();
            doacaoDAO.inserir(doacao);
         
            
           
            
               out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='refresh' content='4;URL=Home/home.jsp'>"); 
            out.println("<style>");
                out.println("@font-face{font-family: WorkSans; src: url('/SA-JSP/fontes/WorkSans-Regular.ttf');  }");
                out.println("@font-face{font-family: WorkSansLight; src: url('/SA-JSP/fontes/WorkSansLight');  }");
                out.println(".popup {");
                    out.println("backgroud-color: black; width:100%; height:100%; position:fixed; top: 0; justify-content:center: align-items:center; text-align:center; ");
                out.println("}");
                out.println(".popup .container {");
                    out.println("color: #ffff; margin-top: 200px; text-weight:bold; font-size: 1.5rem;");
                out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style='background: rgba(0,0,0,10);'>");
            out.println("<div class='popup'>");
                out.println("<div class='popup-content'>");
                    out.println("<div class='container' id='container'>");
                        out.println("<lottie-player");
                        out.println("src=\"https://assets5.lottiefiles.com/datafiles/K6S8jDtSdQ7EPjH/data.json\"  background=\"transparent\"  speed=\"1\"  style=\"width: 150px; height: 150px;\"  loop  autoplay >");
                        out.println("</lottie-player>");
                        out.println("<p>Doaçao Realizada com sucesso!</p>");
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
            out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
            out.println("</body>");
            out.println("</html>");
            
            
            }
        }

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
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
