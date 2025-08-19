import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestClient2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            System.out.println("=== Client 2 Started ===");
            calculator.pushValue(50); // This will interfere with Client 1!
            calculator.pushOperation("min");
            int result = calculator.pop();
            System.out.println("Client 2 result: " + result);

        } catch (Exception e) {
            System.err.println("Client 2 error: " + e.getMessage());
        }
    }
}