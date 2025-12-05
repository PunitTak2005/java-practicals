import java.util.Locale;
import java.util.ResourceBundle;

public class I18NDemo {
    public static void main(String[] args) {
        Locale hindi = new Locale("hi", "IN");
        ResourceBundle rb = ResourceBundle.getBundle("Messages", hindi);
        System.out.println(rb.getString("welcome"));
    }
}
