import java.rmi.*;

public class RMIClient {
    public static void main(String[] args) {
        try {
            SayHello hello = (SayHello) Naming.lookup("rmi://localhost:5000/hello");

            User u = new User("Ankur");

            String response = hello.greet(u);
            System.out.println("Server Response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
