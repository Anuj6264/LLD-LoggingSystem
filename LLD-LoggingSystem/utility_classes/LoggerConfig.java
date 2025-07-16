package utility_classes;

import enums.LogLevel;

public class LoggerConfig {
    private LogLevel logLevel;

    public LoggerConfig(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
