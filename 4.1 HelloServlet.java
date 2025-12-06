import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");

        out.println("<html><body>");
        out.println("<h2>Hello " + name + ", Welcome to J2EE Application!</h2>");
        out.println("<p>This response is generated using HTTP GET request.</p>");
        out.println("</body></html>");
    }
}
