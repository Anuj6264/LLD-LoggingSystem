package log_handler_cor;

import appending_strategy.LogAppender;
import enums.LogLevel;
import utility_classes.LogMessage;

public abstract class LogHandler {
    private LogHandler nextLogger;
    private LogLevel handlerLevel;

    public LogHandler(LogLevel handlerLevel) {
        this.handlerLevel = handlerLevel;
    }

    public void setNextLogger(LogHandler nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogLevel logLevel, String message, LogAppender logAppender) {
        if(logLevel == handlerLevel) {
            LogMessage logMessage = new LogMessage(logLevel, message);
            if(logAppender != null)
                logAppender.append(logMessage);
            write(message);
        } else if(nextLogger != null) {
            nextLogger.logMessage(logLevel, message, logAppender);
        }
    }

    public static LogHandler setChainOfLoggers() {
        LogHandler errorLogger = new ErrorLogHandler();
        LogHandler infoLogger = new InfoLogHandler();
        LogHandler debugLogger = new DebugLogHandler();
        
        // Chain: DEBUG -> INFO -> ERROR (each handler only handles its specific level)
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        
        return debugLogger; // Return the head of the chain
    }

    public abstract void write(String message);

}
