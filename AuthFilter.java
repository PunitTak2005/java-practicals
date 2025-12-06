import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String username = request.getParameter("username");

        if (username == null || username.trim().equals("")) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Access Denied! Username required.</h3>");
        } else {
            chain.doFilter(request, response);  // allow request
        }
    }

    public void destroy() {}
}
