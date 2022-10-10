package pt.mankings.ies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyFirstServlet", urlPatterns = { "/MyFirstServlet" })
public class MyFirstServlet extends HttpServlet {

  private static final long serialVersionUID = -1915463532411657451L;

  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String username = request.getParameter("username");
    if(username == null) throw new NullPointerException("You didn't provide an username!");

    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Mankings Meet&Greet</title>");
      out.println("</head>");
      out.println("<body>");

      out.println("<h2>");
      switch (username.toLowerCase()) {
        case "mankings":
          out.println("O homem, a lenda! O manco!");
          break;
        case "laifer":
          out.println("Meu puto Laifer");
          break;
        case "arturito":
          out.println("Arturito pequinininho");
          break;
        case "reis":
          out.println("Reis rato do esgoto!");
          break;
        case "pareidrieds":
          out.println("Pá ratisse");
          break;
        case "isac":
          out.println("Isac :skullemoji:");
          break;
        case "piti":
          out.println("Goat");
          break;
        default:
          out.println("Ou sou preguiçoso ou és desconhecido");
      }
      out.print("</h2>");

      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    // Do some other work
  }
}