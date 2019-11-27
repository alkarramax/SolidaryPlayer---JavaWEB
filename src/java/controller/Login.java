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
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Email ou senha incorreto!!');");
                    out.println("location='/SA-JSP/Home/home.jsp';");
                    out.println("</script>");
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