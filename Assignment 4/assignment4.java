import java.util.*;

class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

class InvalidIDException extends Exception {
    InvalidIDException(String msg) {
        super(msg);
    }
}

public class assignment4 {
    static class Account {
        int cid;
        String cname;
        double amount;

        Account(int cid, String cname, double amount) {
            this.cid = cid;
            this.cname = cname;
            this.amount = amount;
        }
    }

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\n--- BANKING SYSTEM ---");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        withdrawAmount();
                        break;
                    case 3:
                        displayAccounts();
                        break;
                    case 4:
                        System.out.println("Thank you!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InvalidAmountException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InvalidIDException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void createAccount() throws Exception {
        System.out.print("Enter Customer ID (1-20): ");
        int cid = sc.nextInt();

        // Validate CID
        if (cid < 1 || cid > 20) {
            throw new InvalidIDException("Customer ID must be between 1 and 20");
        }

        // Check if ID already exists
        for (Account acc : accounts) {
            if (acc.cid == cid) {
                throw new InvalidIDException("Customer ID " + cid + " already exists");
            }
        }

        System.out.print("Enter Customer Name: ");
        String cname = sc.next();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Validate amount
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }

        if (amount < 1000) {
            throw new InvalidAmountException("Minimum balance required is Rs. 1000");
        }

        // Create and add account
        accounts.add(new Account(cid, cname, amount));
        System.out.println("Account created successfully!");
    }

    static void withdrawAmount() throws Exception {
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();

        System.out.print("Enter Withdrawal Amount: ");
        double wth_amt = sc.nextDouble();

        // Validate withdrawal amount
        if (wth_amt <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }

        // Find account
        boolean found = false;
        for (Account acc : accounts) {
            if (acc.cid == cid) {
                found = true;
                if (wth_amt > acc.amount) {
                    throw new InvalidAmountException("Insufficient balance. Current balance: " + acc.amount);
                }
                acc.amount -= wth_amt;
                System.out.println("Withdrawal successful!");
                System.out.println("Remaining balance: " + acc.amount);
                break;
            }
        }

        if (!found) {
            throw new InvalidIDException("Customer ID " + cid + " not found");
        }
    }

    static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("CID | Name | Amount");
        System.out.println("----|------|--------");

        for (Account acc : accounts) {
            System.out.println(acc.cid + "   | " + acc.cname + " | " + acc.amount);
        }
    }
}
