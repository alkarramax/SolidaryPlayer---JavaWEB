
package controller;

import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           HttpSession session = request.getSession();
           
           String email = request.getParameter("email");        
           String senha = request.getParameter("senha");
            
            if("admin@admin".equals(email) && "admin".equals(senha)) {
                response.sendRedirect("/SA-JSP/Adm/administrador.jsp");
            }

            try {
                Connection connection = DBConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from softplayer where email='"+email+"' and senha='"+senha+"'");
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
