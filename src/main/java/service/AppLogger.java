package service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLogger {

    private static Logger logger = Logger.getLogger("MyAppLogger");
    private static FileHandler fileHandler;

    // This is to set up where logs are saved and how they look
    static {
        try {
            fileHandler = new FileHandler("application.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This logs an info message
    public static void log(String message) {
        logger.info(message);
    }

    // This logs an error message with details
    public static void logError(String message, Throwable error) {
        logger.severe(message + " - Error: " + error.getMessage());
    }
}
