
package controller;

import DAO.JDBCSoftplayerDAO;
import DB.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Softplayer;

public class CadastroSoftplayer extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            String cargo = request.getParameter("cargo");
            String unidade = request.getParameter("unidade");
           
            Connection connection = DBConnection.getConnection();
           
            String sql = "SELECT * FROM softplayer where email=?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                  if(email.equals(rs.getString("email"))) {
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
                                    out.println("<p>Email já cadastrado!</p>");
                                out.println("</div>");
                            out.println("</div>");
                        out.println("</div>");
                        out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
                        out.println("</body>");
                        out.println("</html>");
                      return;
                  } 
            }
            
            String hashPassword = hashPassword(senha);
            
            Softplayer softplayer = new Softplayer();

            softplayer.setNome(nome);
            softplayer.setEmail(email);
            softplayer.setCargo(cargo);
            softplayer.setUnidade(unidade);
            softplayer.setSenha(hashPassword);

            JDBCSoftplayerDAO inserirDAO = new JDBCSoftplayerDAO();
            inserirDAO.inserir(softplayer);
            
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
                            out.println("<p>Cadastro realizado com sucesso!</p>");
                        out.println("</div>");
                    out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>");
                out.println("</body>");
                out.println("</html>");

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
                Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroSoftplayer.class.getName()).log(Level.SEVERE, null, ex);
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
