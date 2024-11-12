package service;

public class InputValidator {
    public static boolean isValidEmail(String email) {
        // This checks if the email follows the email format
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidPassword(String password) {
        // This checks if the password is at least 8 characters and includes uppercase, lowercase, and a number
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$");
    }
}
