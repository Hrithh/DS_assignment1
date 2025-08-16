import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.RemoteServer;
import java.util.Stack;
import java.util.Collections;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack = new Stack<>();

    public CalculatorImpl() throws RemoteException {}

    // Implement ALL required methods from Calculator interface
    public synchronized void pushValue(int val) throws RemoteException {
        try {
            System.out.println("Client " + RemoteServer.getClientHost() + " pushed: " + val);
        } catch (ServerNotActiveException e) {
            System.out.println("Local test push: " + val);  // Fallback message
        }
        stack.push(val);
    }

    public synchronized void pushOperation(String operator) throws RemoteException {
        switch (operator) {
            case "max":
                stack.push(Collections.max(stack));
                break;
            case "min":
                stack.push(Collections.min(stack));
                break;
            // Add gcd/lcm cases later
            default:
                throw new RemoteException("Unknown operator: " + operator);
        }
    }

    public synchronized int pop() throws RemoteException {
        return stack.pop();
    }

    public synchronized boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    public synchronized int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RemoteException("Delay interrupted", e);
        }
        return pop();
    }
}