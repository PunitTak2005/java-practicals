import javax.naming.*;
import java.util.Hashtable;

public class JNDIDemo {
    public static void main(String[] args) throws Exception {
        Hashtable<String, String> env = new Hashtable<>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        env.put(Context.PROVIDER_URL, "file:/tmp");  // Fixed: Added missing quote

        Context ctx = new InitialContext(env);
        System.out.println("JNDI Context Initialized Successfully!");
    }
}
