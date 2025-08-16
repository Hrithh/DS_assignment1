import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {
    public HelloWorldImpl() throws RemoteException {}

    public String sayHello() throws RemoteException {
        return "Hello, RMI World!";
    }
}