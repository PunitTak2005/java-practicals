//2.2 client side code


import java.io.*;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("Hello Server, this is Client!");

        s.close();
    }
}
