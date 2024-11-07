package Bank;

public class User {
    private String username;
    private String password;
    private BankAccount account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new BankAccount(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public void displayUserInfo() {
        System.out.println("username: " + username);
        System.out.println("account number: " + account.getAccountNumber());
        System.out.println("account balance: " + account.getBalance());
    }
    public void updateAccountDetails(String newUsername, String newPassword) {
        if (!newUsername.isEmpty()) {
            setUsername(newUsername);
            System.out.println("updated");
        } else {
            System.out.println("error");
        }
        if (!newPassword.isEmpty()) {
            setPassword(newPassword);
            System.out.println("successful.");
        } else {
            System.out.println("error");
        }
    }
}

