package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(new Date(), "deposit", amount));
            System.out.println("deposited: " + amount + "new balance: " + balance);
        } else {
            System.out.println("must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                transactionHistory.add(new Transaction(new Date(), "withdrawal", amount));
                System.out.println("withdrew: " + amount + "new balance: " + balance);
            } else {
                System.out.println("insufficient balance");
            }
        } else {
            System.out.println(",ust be positive");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("history: ");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public double getBalance() {
        return balance;
    }

    // Setter for account balance
    public void setBalance(double balance) {
        if (balance >= 0) {  // Balance should not be negative
            this.balance = balance;
            System.out.println("Balance updated to: $" + balance);
        } else {
            System.out.println("Invalid balance. Balance cannot be negative.");
        }
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for account number
    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && !accountNumber.isEmpty()) {
            this.accountNumber = accountNumber;
            System.out.println("Account number updated to: " + accountNumber);
        } else {
            System.out.println("Invalid account number.");
        }
    }
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = new ArrayList<>(transactionHistory);
    }
}
