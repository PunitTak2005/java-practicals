import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DemoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init() called - Servlet Initialization");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Request object
        String name = req.getParameter("username");

        // Session Handling
        HttpSession session = req.getSession();
        session.setAttribute("user", name);

        // ServletConfig demo
        ServletConfig config = getServletConfig();
        String adminEmail = config.getInitParameter("adminEmail");

        // ServletContext demo
        ServletContext context = getServletContext();
        String appVersion = context.getInitParameter("version");

        // Response
        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<p>Admin Email (ServletConfig): " + adminEmail + "</p>");
        out.println("<p>Application Version (ServletContext): " + appVersion + "</p>");
        out.println("<p>Your session ID: " + session.getId() + "</p>");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() called - Servlet Destroyed");
    }
}
