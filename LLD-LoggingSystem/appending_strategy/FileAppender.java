package appending_strategy;

import java.io.FileWriter;
import java.io.IOException;

import utility_classes.LogMessage;

public class FileAppender implements LogAppender {
    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage logMessage) {
         try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage.toString() + "\n"); // Write log to file
        } catch (IOException e) {
            e.printStackTrace(); // Print error if file writing fails
        }
    }
}
