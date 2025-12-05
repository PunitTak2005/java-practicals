import java.rmi.*;

public interface SayHello extends Remote {
    String greet(User user) throws RemoteException;
}
