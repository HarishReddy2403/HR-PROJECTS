import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        User user = new User("12345", "6789", 1000.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userIdInput = scanner.nextLine().trim(); // Trim whitespace
        System.out.print("Enter PIN: ");
        String pinInput = scanner.nextLine().trim(); // Trim whitespace

        if (user.getUserId().equals(userIdInput) && user.verifyPin(pinInput)) {
            System.out.println("Welcome to the ATM!");
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Current balance: $" + user.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        user.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's User ID: ");
                        String recipientId = scanner.next();
                        System.out.print("Enter transfer amount: $");
                        double transferAmount = scanner.nextDouble();
                        if (recipientId.equals(user.getUserId())) {
                            System.out.println("Cannot transfer to yourself.");
                        } else {
                            User recipient = new User("54321", "9876", 500.0); // Example recipient user
                            user.transfer(recipient, transferAmount);
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN. Exiting.");
        }
    }
}
class User {
    private String userId;
    private String userPin;
    private double balance;

    public User(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
    }

    public String getUserId() {
        return userId;
    }

    public boolean verifyPin(String inputPin) {
        return userPin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }
}