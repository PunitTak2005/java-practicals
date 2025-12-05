//2.2 server code

import java.io.*;
import java.net.*;

public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started... Waiting for client...");

        Socket s = ss.accept();
        System.out.println("Client connected!");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(s.getInputStream())
        );

        String msg = br.readLine();
        System.out.println("Message received: " + msg);

        ss.close();
    }
}
