import java.io.*;
import java.util.Scanner;

public class ViewBalance {
    public static void viewBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tEnter your number account: ");
        String accountNumber = sc.nextLine();

        try {
            File file = new File("users.txt");
            Scanner fileScanner = new Scanner(file);
            boolean found = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts[3].equals(accountNumber)){
                    System.out.println("\n\t\tYour account balance is: RM " + parts[5]);
                    found = true;
                }
            }
            fileScanner.close();
            if (!found) {
                System.out.println("\n\t\tWrong Account Number");
            }
            System.out.print("\n\t\tany other transaction[1] stop [0] : ");
            int i = sc.nextInt();
            if (i == 1) {
                Option.option();
            } else {
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\t\tAn error occurred.");
            e.printStackTrace();
        }
    }
}
