import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloWorldImpl obj = new HelloWorldImpl();
            // Connect to EXISTING registry (don't create new one)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.rebind("HelloService", obj);
            System.out.println("Server ready!");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}