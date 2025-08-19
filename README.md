# DS_assignment1
Assignment 1 - Introduction to Java RMI

## Overview
A distributed calculator system using Java RMI with shared stack architecture. Supports basic operations and advanced mathematical functions with multi-client access.

## Prerequisites
- Java 11 or higher
- RMI registry (included with Java)

## How to Run

### 1. Compile all files [Terminal 1]
javac *.java

### 2. Compile and Start RMI Registry [Terminal 2]
rmiregistry 1099

### 3. Start the Calculator Server [Terminal 3]
java CalculatorServer

### 4. Run Clients(basic test client) [Terminal 4]
java CalculatorClient

### 5. Run Clients(comprehensive single client test) [Terminal 4]
java TestSingleClient

### 6. Run Multi-Client Test [Terminal 5,6,7]
java TestClient1 -> terminal 4
java TestClient2 -> terminal 5
java TestClient3 -> terminal 6

Expected Results
Single Client Test (TestSingleClient)
max(10,20) → 20
gcd(18,24,36) → 6
lcm(4,5,6) → 60

Multi-Client Test
Clients will interfere with each other (expected behavior)
Results may be unexpected due to shared stack
Demonstrates concurrent access patterns

Important Notes
- Compilation First: Must compile before starting registry
- Port 1099: Ensure no other process is using this port
- Terminal Management: Use separate terminal tabs/windows
- Execution Order: Compile → Registry → Server → Clients

Troubleshooting
Error: ClassNotFound
Solution: Ensure you compiled with javac *.java

Error: PortAlreadyInUse
Solution: Find and kill process using port 1099:
lsof -ti:1099 | xargs kill -9