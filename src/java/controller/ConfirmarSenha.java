/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfirmarSenha extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            Connection connDoacao = DBConnection.getConnection();
            
            String email = request.getParameter("email");
            
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmarSenha");
            
            String hash1 = hashPassword(senha);
            String hash2 = hashPassword(confirmarSenha);
            
            
            if(hash1.equals(hash2)) {
                
                String query = "update softplayer set senha=? where email='"+email+"'";
                PreparedStatement stmt = connDoacao.prepareStatement(query);

                stmt.setString(1, hash1);
                stmt.executeUpdate();
                connDoacao.close();
                
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
                            out.println("<p>Senha alterada com sucesso!</p>");
                        out.println("</div>");
                    out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
                out.println("</body>");
                out.println("</html>");
                
            } else {
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('A senha precisa ser igual!!');");
                out.println("location='/SA-JSP/Home/EsquecerSenha/confirmarSenha.jsp?email="+email+"';");
                out.println("</script>");
                
            }
        }
    }
    
     public static String hashPassword(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2*hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
           }
         
           digest = sb.toString();
         
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digest;
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
        try {
            try {
                processRequest(request, response);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmarSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
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
