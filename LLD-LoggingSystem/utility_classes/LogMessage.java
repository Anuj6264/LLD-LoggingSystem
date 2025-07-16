package utility_classes;
import java.time.LocalDateTime;
import enums.LogLevel;

public class LogMessage {
    
    private LogLevel logLevel;
    private String message;
    private LocalDateTime timestamp;

    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getLogMessage() {
        return "[" + logLevel + "] " + timestamp + " - " + message;  
    }

    @Override
    public String toString() {
        return getLogMessage();
    }

}
