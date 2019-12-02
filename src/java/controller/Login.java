package controller;

import DB.DBConnection;
import RKinfotech.MysqlMd5;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();

            String email = request.getParameter("email");        
            String senha = request.getParameter("senha");
            
            String hashPassword = MysqlMd5.getRKmd5(senha);
            
           
            if("admin@admin".equals(email) && "admin".equals(senha)) {
                response.sendRedirect("/SA-JSP/Adm/administrador.jsp");
            }
          
            try {
                Connection connection = DBConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from softplayer where email='"+email+"' and senha='"+hashPassword+"'");
                if(rs.next()) {
                    session.setAttribute("nome", rs.getString("nome"));
                    session.setAttribute("id", rs.getInt("id_softplayer"));
                    response.sendRedirect("/SA-JSP/Home/home.jsp");
                } else {
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
                                out.println("<p>Email ou senha incorretos!</p>");
                            out.println("</div>");
                        out.println("</div>");
                    out.println("</div>");
                    out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
                    out.println("</body>");
                    out.println("</html>");
                }

            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error " + e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}