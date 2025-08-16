import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            HelloWorld stub = (HelloWorld) registry.lookup("HelloService");
            System.out.println("Server says: " + stub.sayHello());
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}