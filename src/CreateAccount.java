import java.io.*;
import java.util.Scanner;

class CreateAccount {
    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tCreate your Online Banking Account ");
        System.out.println("Creating the file at: " + new File("users.txt").getAbsolutePath());
        System.out.print("\n\tEnter your name: ");
        String name = sc.nextLine();

        String username;
        boolean usernameExists;

        do {
            System.out.print("\tEnter your username: ");
            username = sc.nextLine();
            usernameExists = false; 

            try {
                File file = new File("users.txt");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",");
                    if (parts[0].equals(username)) {
                        System.out.println("\tUsername already exists. Please choose a different one.");
                        usernameExists = true;
                        break;
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("\tAn error occurred while checking username availability.");
                e.printStackTrace();
            }
        } while (usernameExists);

        String password;
        String confirmPassword;
        boolean passwordsMatch = false;

        do {
            System.out.print("\tEnter a password: ");
            password = sc.nextLine();

            System.out.print("\tConfirm your password: ");
            confirmPassword = sc.nextLine();

            if (!password.equals(confirmPassword)) {
                System.out.println("\n\t\tPasswords do not match. Please try again.");
            } else {
                passwordsMatch = true;
            }
        } while (!passwordsMatch);

        System.out.print("\tEnter your Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("\tEnter your Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("\tEnter your Account Balance: RM");
        double accountBalance = sc.nextDouble();

        try {
            FileWriter writer = new FileWriter("users.txt", true);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(username + "," + password + "," + name + "," + accountNumber + ","
                    + phoneNumber + "," + accountBalance + "\n");
            bufferedWriter.close();

            System.out.println("\n\tAccount created successfully! Please proceed to login.");
            Login.login();
        } catch (IOException e) {
            System.out.println("\tAn error occurred.");
            e.printStackTrace();
        }
    }
}



