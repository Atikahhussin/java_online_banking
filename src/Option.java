import java.util.Scanner;

public class Option {
    public static void option() {
        System.out.println("\n\t\tChoose your transaction: ");
        System.out.println("\n\t\t1. View Account Balance"); 
        System.out.println("\t\t2. Cash Deposit/ Payment"); 
        System.out.println("\t\t3. Cash Withdrawal"); 
        System.out.println("\t\t4. Transfer"); 

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\t\tYour Option: ");
        int option = sc.nextInt();

        switch(option) {
            case 1:
            ViewBalance.viewBalance();
            break;

            case 2:
            Deposit.deposit();
            break;

            case 3:
            Withdrawal.withdrawal();
            break;

            case 4:
            Transfer.transfer();
            break;

            default:
            System.out.println("\t\tYour option is unavailable.");
            Option.option();
            break;
        }
    }
}
