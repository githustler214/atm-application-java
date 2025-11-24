public class Main {
    public static void main(String[] args) {
        Account acc = new Account("Khushi", 1234, 5000.0);
        ATM atm = new ATM(acc);
        atm.start();
    }
}
