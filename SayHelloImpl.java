import java.rmi.server.*;
import java.rmi.*;

public class SayHelloImpl extends UnicastRemoteObject implements SayHello {

    protected SayHelloImpl() throws RemoteException {
        super();
    }

    public String greet(User user) throws RemoteException {
        return "Hello " + user.name + " from RMI Server!";
    }
}

