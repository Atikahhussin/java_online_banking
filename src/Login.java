import java.io.*;
import java.util.Scanner;

class Login {
    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tLogin to your Online Banking Account ");

        System.out.print("\n\tEnter your username: ");
        String username = sc.nextLine();

        System.out.print("\tEnter your password: ");
        String password = sc.nextLine();

        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }
            fileScanner.close();
            if (found) {
                System.out.println("\n\t\tLogged in successfully! Welcome back, " + username + "!");
                Option.option();
            } else {
                System.out.println("\n\t\tInvalid username or password. Please try again.");
                Home.main(new String[0]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\t\tAn error occurred.");
            e.printStackTrace();
        } 
    }
}