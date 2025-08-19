import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImplementation obj = new CalculatorImplementation();
            // Connect to EXISTING registry (don't create new one)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.rebind("CalculatorService", obj);
            System.out.println("Calculator server ready!");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}