public class Account {
    private String userName;
    private int userPin;
    private double balance;
    private StringBuilder history;

    public Account(String userName, int userPin, double balance) {
        this.userName = userName;
        this.userPin = userPin;
        this.balance = balance;
        this.history = new StringBuilder();
    }

    public boolean authenticate(int pin) {
        return this.userPin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.append("Deposited: ₹").append(amount).append("\n");
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        history.append("Withdrawn: ₹").append(amount).append("\n");
        return true;
    }

    public String getHistory() {
        if (history.length() == 0) return "No transactions yet.";
        return history.toString();
    }

    public String getUserName() {
        return userName;
    }
}
