package controllers;

import appending_strategy.LogAppender;
import enums.LogLevel;
import log_handler_cor.LogHandler;
import utility_classes.LoggerConfig;

public class Logger {
    private static Logger instance;
    private LogHandler logHandler;
    private LoggerConfig loggerConfig;

    private Logger(LogHandler logHandler, LoggerConfig loggerConfig) {
        this.logHandler = LogHandler.setChainOfLoggers();
        this.loggerConfig = loggerConfig;
    }

    public static synchronized Logger getInstance(LogHandler logHandler, LoggerConfig loggerConfig) {
        if(instance == null)
            instance = new Logger(logHandler, loggerConfig);
        return instance;
    }

    public void debug(String message, LogAppender logAppender) {
        if(LogLevel.DEBUG.getValue() >= loggerConfig.getLogLevel().getValue())
            logHandler.logMessage(LogLevel.DEBUG, message, logAppender);
    }

    public void info(String message, LogAppender logAppender) {
        if(LogLevel.INFO.getValue() >= loggerConfig.getLogLevel().getValue())
            logHandler.logMessage(LogLevel.INFO, message, logAppender);
    }

    public void error(String message, LogAppender logAppender) {
        if(LogLevel.ERROR.getValue() >= loggerConfig.getLogLevel().getValue())
            logHandler.logMessage(LogLevel.ERROR, message, logAppender);
    }
}
