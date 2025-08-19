import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestClient3 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            System.out.println("=== Client 3 Started ===");
            // Test delayPop with interference
            calculator.pushValue(999); // More interference!
            int result = calculator.delayPop(1000);
            System.out.println("Client 3 delayed result: " + result);

        } catch (Exception e) {
            System.err.println("Client 3 error: " + e.getMessage());
        }
    }
}