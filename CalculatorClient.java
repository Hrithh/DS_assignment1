import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            // Test basic operations
            calculator.pushValue(8);
            calculator.pushValue(12);
            calculator.pushOperation("gcd");  // Pushes 4 (gcd of 8,12)
            calculator.pushValue(5);          // Add another value
            calculator.pushOperation("lcm");  // lcm(4,5) = 20
            System.out.println("Result: " + calculator.pop()); // Now prints 20
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}