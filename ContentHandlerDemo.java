//2.3
import java.net.*;
import java.io.*;

public class ContentHandlerDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

