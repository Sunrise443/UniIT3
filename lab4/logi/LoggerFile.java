package lab4.logi;

import java.io.IOException;
import java.util.logging.*;

public class LoggerFile {
    private static final Logger lr = Logger.getLogger(lab4.logi.LoggerFile.class.getName());
    
    static {
        try {
            FileHandler fileHandler = new FileHandler("lab4/logi/ExceptionLogs.txt", true);
            SimpleFormatter formatter = new SimpleFormatter();

            fileHandler.setFormatter(formatter);
            lr.addHandler(fileHandler);
            lr.setLevel(Level.ALL);

            System.out.println("The error was logged.");
        } catch (IOException e) {
            lr.log(Level.SEVERE, "Logger file error", e);
        }
    }

    public void log (String message) {
        lr.log(Level.ALL, message);
    }
}
