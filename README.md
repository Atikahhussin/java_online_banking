Java Online Banking System

A console-based banking application developed in Java. This system demonstrates core programming concepts including File I/O, Object-Oriented Programming, and CRUD (Create, Read, Update, Delete) operations by managing user data through a flat-file database.

🚀 Features

**User Registration**: Create a new banking account with a unique username, password, and initial balance.


**Secure Login**: Authentication system that validates credentials against stored user data.

**Account Operations**:

- View Balance: Real-time balance inquiry using account numbers.

- Deposit: Add funds to an existing account.

- Withdrawal: Remove funds with built-in validation for insufficient balances.

- Transfer: Move funds between two different account numbers.

**Data Persistence**: All user information and account balances are saved in users.txt to ensure data is kept after the program closes.

🛠️ Technical Implementation

- Language: Java

- Storage: Text-based file handling (FileReader, FileWriter, BufferedReader, BufferedWriter).

Logic:

- Home.java: The entry point of the application.

- Transfer.java / Deposit.java / Withdrawal.java: Use temporary files (tempUsers.txt) to safely update account balances without data loss.

📁 File Structure

- src/: Contains the Java source files (Home.java, Login.java, CreateAccount.java, etc.).

- users.txt: The primary "database" file where user records are stored.

- tempUsers.txt: Used for intermediate processing during transactions.

⚙️ How to Run

1.	Clone the repository:

git clone https://github.com/Atikahhussin/java_online_banking.git

2.	Navigate to the source directory:

cd java_online_banking/src

3.	Compile the program:

javac *.java

4.	Launch the application:

java Home


