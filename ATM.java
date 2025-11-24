import java.util.Scanner;

public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("===== Welcome to Java ATM =====");

        // Login
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (!account.authenticate(pin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        System.out.println("Login successful! Hello " + account.getUserName());

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    System.out.println("Deposit successful!");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wd = scanner.nextDouble();

                    if (account.withdraw(wd))
                        System.out.println("Withdrawal successful!");
                    else
                        System.out.println("Insufficient balance!");
                    break;

                case 4:
                    System.out.println("===== Transaction History =====");
                    System.out.println(account.getHistory());
                    break;

                case 5:
                    System.out.println("Thank you for using Java ATM. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

