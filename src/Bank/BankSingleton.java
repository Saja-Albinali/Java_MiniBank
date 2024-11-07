package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
    private static BankSingleton instance;
    private List<User> users;
    private BankSingleton() {
        users = new ArrayList<>();
    }

    public static BankSingleton getInstance() {
        if (instance == null) {
            instance = new BankSingleton();
        }
        return instance;
    }

    private void addUser(User user) {
        users.add(user);
    }

    public boolean createUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("error");
            return false;
        } else {
            User newUser = new User(username, password);
            addUser(newUser);
            System.out.println("username:" + username);
            return true;
        }
    }

    private boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void displayAccountDetails(String username, String password) {
        User user = authenticateUser(username, password);

        if (user != null) {
            user.displayUserInfo();
        } else {
            System.out.println("invalid");
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("no users");
        } else {
            System.out.println("users: ");
            for (User user : users) {
                user.displayUserInfo();
            }
        }
    }
}
