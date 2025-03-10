import java.util.*;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private String accountType; 
    private double balance;
    private List<String> transactionHistory;

    // Overdraft limit for Current/Business accounts
    private static final double OVERDRAFT_LIMIT = 10000.0;
    
    // Minimum balance constraints
    private static final double MIN_BALANCE_SAVINGS = 1000.0;
    private static final double MIN_BALANCE_CURRENT = 5000.0;

    public BankAccount(String accountNumber, String accountHolder, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account Created with Balance: ₹" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount + " | Balance: ₹" + balance);
        System.out.println("Deposit Successful. New Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (accountType.equalsIgnoreCase("Savings")) {
            if (balance - amount < 0) {
                System.out.println("Insufficient balance! No overdraft allowed for Savings Account.");
                return;
            }
        } else { // Current or Business Account
            if (balance - amount < -OVERDRAFT_LIMIT) {
                System.out.println("Overdraft limit exceeded! Cannot withdraw.");
                return;
            }
        }

        balance -= amount;
        transactionHistory.add("Withdrawn: ₹" + amount + " | Balance: ₹" + balance);
        System.out.println("Withdrawal Successful. New Balance: ₹" + balance);
    }

    public void checkBalance() {
        System.out.println("Account Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankingSystem {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static final String ADMIN_PASSWORD = "Admin#bank2"; // Example admin password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank System Menu ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Client Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            
            int userType = scanner.nextInt();

            if (userType == 1) {
                // Admin Login
                System.out.print("Enter Admin Password: ");
                String password = scanner.next();
                if (!password.equals(ADMIN_PASSWORD)) {
                    System.out.println("Invalid Password! Access Denied.");
                    continue;
                }
                // Admin Menu
                adminMenu(scanner);
            } else if (userType == 2) {
                // Client Menu
                clientMenu(scanner);
            } else if (userType == 3) {
                System.out.println("Thank you for using the Bank System!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Exit to Main Menu");
            System.out.print("Enter Choice: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                createAccount(scanner);
            } else if (choice == 2) {
                return; // Exit to main menu
            } else {
                System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    private static void clientMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Client Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Enter Choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performTransaction(scanner, "Deposit");
                    break;
                case 2:
                    performTransaction(scanner, "Withdraw");
                    break;
                case 3:
                    checkBalance(scanner);
                    break;
                case 4:
                    viewTransactionHistory(scanner);
                    break;
                case 5:
                    return; // Exit to main menu
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    public static void createAccount(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();

        if (accounts.containsKey(accNumber)) {
            System.out.println("Account Number already exists! Try again.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        scanner.nextLine(); 
        String accHolder = scanner.nextLine();

        System.out.print("Enter Account Type (Savings, Current, Business): ");
        String accType = scanner.next();

        double minBalance = (accType.equalsIgnoreCase("Savings")) ? 1000.0 : 5000.0;
        System.out.print("Enter Initial Deposit (Min ₹" + minBalance + "): ");
        double initialDeposit = scanner.nextDouble();

        if (initialDeposit < minBalance) {
            System.out.println("Insufficient Initial Deposit! Minimum required: ₹" + minBalance);
            return;
        }

        BankAccount newAccount = new BankAccount(accNumber, accHolder, accType, initialDeposit);
        accounts.put(accNumber, newAccount);
        System.out.println("Account Successfully Created!");
    }

    public static void performTransaction(Scanner scanner, String transactionType) {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();

        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        if (transactionType.equals("Deposit")) {
            account.deposit(amount);
        } else if (transactionType.equals("Withdraw")) {
            account.withdraw(amount);
        }
    }

    public static void checkBalance(Scanner scanner) {
        System.out.println("Enter Account Number: ");
        String accNumber = scanner.next();

        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        account.checkBalance();
    }

    public static void viewTransactionHistory(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();

        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        account.showTransactionHistory();
    }
}