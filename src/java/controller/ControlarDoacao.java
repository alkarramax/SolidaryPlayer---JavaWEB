/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alkar
 */
public class ControlarDoacao extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            HttpSession sessao = request.getSession();
            
            String id_campanha = request.getParameter("c");
            
            if(sessao.getAttribute("id") == null) {
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
                        out.println("src=\"https://assets6.lottiefiles.com/datafiles/vi3GofRTh0thGPn/data.json\"  background=\"transparent\"  speed=\"1\"  style=\"width: 150px; height: 150px;\"  loop  autoplay >");
                        out.println("</lottie-player>");
                        out.println("<p>Você precisa estar logado para doar!</p>");
                    out.println("</div>");
                out.println("</div>");
            out.println("</div>");
            out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
            out.println("</body>");
            out.println("</html>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("location='/SA-JSP/SobreCampanha/sobreCampanha.jsp?id_campanha="+id_campanha+"';");
                out.println("</script>");
            }
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
