import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Create RMI registry programmatically on port 5000
            LocateRegistry.createRegistry(5000);

            // Create remote object
            SayHelloImpl obj = new SayHelloImpl();

            // Bind object to naming service
            Naming.rebind("rmi://localhost:5000/hello", obj);

            System.out.println("RMI Server Started on port 5000...");
            System.out.println("Remote object bound to 'hello' service.");

        } catch (RemoteException e) {
            System.err.println("RMI Registry creation failed: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
