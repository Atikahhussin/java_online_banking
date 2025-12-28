import java.io.*;
import java.util.Scanner;

public class Withdrawal {
    public static void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tEnter your number account: ");
        String accountNumber = sc.nextLine();

        try {
            File file = new File("users.txt");
            File tempFile = new File("tempUsers.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            boolean found = false;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(accountNumber)) {
                    found = true;
                    System.out.print("\n\t\tEnter amount you wish to withdraw: RM");
                    float amount = sc.nextFloat();
                    double accountBalance = Double.parseDouble(parts[5]);

                    if (amount <= accountBalance) {
                        accountBalance -= amount;
                        parts[5] = String.valueOf(accountBalance); 

                        System.out.println("\n\t\tYour updated balance is: RM " + parts[5]);
                    } else {
                        System.out.println("\n\t\tInsufficient balance. Please try again.");
                    }
                }

                for (String part : parts) {
                    writer.write(part);
                    writer.write(",");
                }
                writer.write("\n");

            }

            reader.close();
            writer.close();

            if (!found) {
                System.out.println("\n\t\tWrong Account Number");
            }

            if (file.delete()) {
                tempFile.renameTo(file);
            }

            System.out.print("\n\t\tany other transaction[1] stop [0] : ");
            int i = sc.nextInt();
            if (i == 1) {
                Option.option();
            } else {
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("\t\tAn error occurred.");
            e.printStackTrace();
        }
    }
}
