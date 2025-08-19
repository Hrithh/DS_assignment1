import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestSingleClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            System.out.println("=== Testing Single Client ===");

            // Test 1: Basic operations
            calculator.pushValue(10);
            calculator.pushValue(20);
            calculator.pushOperation("max");
            System.out.println("Max(10,20): " + calculator.pop()); // Should be 20

            // Test 2: GCD with multiple values
            calculator.pushValue(18);
            calculator.pushValue(24);
            calculator.pushValue(36);
            calculator.pushOperation("gcd");
            System.out.println("GCD(18,24,36): " + calculator.pop()); // Should be 6

            // Test 3: LCM with multiple values
            calculator.pushValue(4);
            calculator.pushValue(5);
            calculator.pushValue(6);
            calculator.pushOperation("lcm");
            System.out.println("LCM(4,5,6): " + calculator.pop()); // Should be 60

            System.out.println("Single client test completed!");

        } catch (Exception e) {
            System.err.println("Test error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}