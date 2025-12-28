import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        System.out.println("\n\t\tWelcome to Java Online Banking!");

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tAre you a new user? (yes/no): ");
        String userInput = sc.nextLine();

        if (userInput.equalsIgnoreCase("yes")) {
            CreateAccount.createAccount();
        } else if (userInput.equalsIgnoreCase("no")) {
            Login.login();
        } else {
            System.out.println("\n\t\tInvalid input. Please enter 'yes' or 'no'.");
            Home.main(new String[0]);
        }
        sc.close();
    }
}

