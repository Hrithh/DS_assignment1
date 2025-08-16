import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            // Test basic operations
            calculator.pushValue(10);
            calculator.pushValue(20);
            calculator.pushOperation("max");
            System.out.println("Result: " + calculator.pop()); // Should print 20
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}