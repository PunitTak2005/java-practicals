
import jakarta.servlet.*;

public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("ServletContext Initialized!");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("ServletContext Destroyed!");
    }
}
