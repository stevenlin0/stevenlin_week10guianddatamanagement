package service;

import java.security.NoSuchAlgorithmException;
import java.util.prefs.Preferences;

public class UserSession {

    private static UserSession instance;
    private static final Object lock = new Object();

    private String userName;
    private String password;
    private String privileges;

    // This is the private to create and save the person's session details
    private UserSession(String userName, String password, String privileges) {
        this.userName = userName;
        this.password = password;
        this.privileges = privileges;

        Preferences userPreferences = Preferences.userRoot().node(this.getClass().getName());
        userPreferences.put("USERNAME", userName);
        userPreferences.put("PASSWORD", password);
        userPreferences.put("PRIVILEGES", privileges);
    }

    // This gives one shared UserSession
    public static UserSession getInstance(String userName, String password, String privileges) {
        synchronized (lock) {
            if (instance == null) {
                instance = new UserSession(userName, password, privileges);
            }
            return instance;
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPrivileges() {
        return this.privileges;
    }

    // This erases the person's data and session info
    public void logout() {
        this.userName = "";
        this.password = "";
        this.privileges = "";
        Preferences userPreferences = Preferences.userRoot().node(this.getClass().getName());
        userPreferences.remove("USERNAME");
        userPreferences.remove("PASSWORD");
        userPreferences.remove("PRIVILEGES");
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", privileges='" + privileges + '\'' +
                '}';
    }
}
