package service;

import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class SessionTimeoutService extends ScheduledService<Void> {
    private static final int TIMEOUT_MINUTES = 10; // This is to set how long to wait
    private long lastActivityTime = System.currentTimeMillis();

    // This is to update the activity time
    public void updateActivity() {
        lastActivityTime = System.currentTimeMillis();
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() {
                // This is to log out the person if the session has been inactive for too long
                if (System.currentTimeMillis() - lastActivityTime > TIMEOUT_MINUTES * 60 * 1000) {
                    Platform.runLater(() -> {
                        UserSession session = UserSession.getInstance("defaultUser", "defaultPassword", "USER");
                        session.logout();
                    });
                }
                return null;
            }
        };
    }
}
