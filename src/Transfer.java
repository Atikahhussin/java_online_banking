import java.io.*;
import java.util.Scanner;

public class Transfer {
    public static void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tEnter your account number: ");
        String accountNumber1 = sc.nextLine();
        System.out.print("\n\tEnter the account number you want to transfer to: ");
        String accountNumber2 = sc.nextLine();
        System.out.print("\n\tEnter amount you wish to transfer: RM");
        float amount = sc.nextFloat();
        
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            File file = new File("users.txt");
            File tempFile = new File("tempUsers.txt");
            reader = new BufferedReader(new FileReader(file));
            writer = new BufferedWriter(new FileWriter(tempFile));
            boolean found1 = false;
            boolean found2 = false;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[3].equals(accountNumber1)) {
                    found1 = true;
                    double accountBalance1 = Double.parseDouble(parts[5]);
                    if (amount <= accountBalance1) {
                        accountBalance1 -= amount;
                        parts[5] = String.valueOf(accountBalance1);
                    } else {
                        System.out.println("\n\t\tInsufficient balance in account " + accountNumber1 + ". Please try again.");
                        System.out.print("\n\t\tany other transaction[1] stop [0] : ");
                        int i = sc.nextInt();
                        if (i == 1) {
                            Option.option();
                        } else {
                            System.exit(0);
                        }
                        return;
                    }
                }
                if (parts[3].equals(accountNumber2)) {
                    found2 = true;
                    double accountBalance2 = Double.parseDouble(parts[5]);
                    accountBalance2 += amount;
                    System.out.println("\n\tYour transaction of RM" + amount + " to account number " + 
                    accountNumber2 + " is successful!");
                    parts[5] = String.valueOf(accountBalance2);
                }

                for (int i = 0; i < parts.length; i++) {
                    writer.write(parts[i]);
                    if (i < parts.length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
                System.out.print("\n\t\tany other transaction[1] stop [0] : ");
                int i = sc.nextInt();
                if (i == 1) {
                    Option.option();
                } else {
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}