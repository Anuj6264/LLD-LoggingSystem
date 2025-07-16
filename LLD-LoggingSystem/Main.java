import appending_strategy.ConsoleAppender;
import appending_strategy.FileAppender;
import appending_strategy.LogAppender;
import controllers.Logger;
import enums.LogLevel;
import log_handler_cor.InfoLogHandler;
import log_handler_cor.LogHandler;
import utility_classes.LoggerConfig;

public class Main {
    
    public static void main(String[] args) {
        LogAppender consoleLogAppender = new ConsoleAppender();
        LogAppender fileLogAppender = new FileAppender("logs.txt");

        LoggerConfig loggerConfig = new LoggerConfig(LogLevel.DEBUG);
        LogHandler logHandler1 = new InfoLogHandler();
        Logger logger = Logger.getInstance(logHandler1, loggerConfig);
        logger.debug("This is a debug message", consoleLogAppender);
        logger.info("This is an info message", fileLogAppender);
        logger.error("This is an error message", consoleLogAppender);
        
        System.out.println("\n=== After setting log level to INFO ===");
        loggerConfig.setLogLevel(LogLevel.INFO);
        logger.debug("This is a debug message", consoleLogAppender);
        logger.info("This is an info message", fileLogAppender);
        logger.error("This is an error message", consoleLogAppender);
    }
}
