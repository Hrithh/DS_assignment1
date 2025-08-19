import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestClient1 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");

            System.out.println("=== Client 1 Started ===");
            calculator.pushValue(100);
            Thread.sleep(500); // Give other clients time to interfere
            calculator.pushValue(200);
            calculator.pushOperation("gcd");
            int result = calculator.pop();
            System.out.println("Client 1 result: " + result);

        } catch (Exception e) {
            System.err.println("Client 1 error: " + e.getMessage());
        }
    }
}