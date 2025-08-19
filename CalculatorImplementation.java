import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.RemoteServer;
import java.util.Stack;
import java.util.Collections;
import java.math.BigInteger;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    private Stack<Integer> stack = new Stack<>();

    public CalculatorImplementation() throws RemoteException {}

    // GCD helper method
    private int computeGcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    // LCM helper method
    private int computeLcm(int a, int b) {
        return (a * b) / computeGcd(a, b);
    }

    public synchronized void pushValue(int val) throws RemoteException {
        try {
            System.out.println("Client " + RemoteServer.getClientHost() + " pushed: " + val);
        } catch (ServerNotActiveException e) {
            System.out.println("Local test push: " + val);
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
            case "gcd":
                if (stack.isEmpty()) throw new RemoteException("Stack empty for GCD");
                int gcdResult = stack.pop();
                while (!stack.isEmpty()) {
                    gcdResult = BigInteger.valueOf(gcdResult)
                            .gcd(BigInteger.valueOf(stack.pop()))
                            .intValue();
                }
                stack.push(gcdResult);
                break;
            case "lcm":
                if (stack.isEmpty()) throw new RemoteException("Stack empty for LCM");
                int lcmResult = stack.pop();
                while (!stack.isEmpty()) {
                    int next = stack.pop();
                    lcmResult = (lcmResult * next) /
                            BigInteger.valueOf(lcmResult)
                                    .gcd(BigInteger.valueOf(next))
                                    .intValue();
                }
                stack.push(lcmResult);
                break;
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