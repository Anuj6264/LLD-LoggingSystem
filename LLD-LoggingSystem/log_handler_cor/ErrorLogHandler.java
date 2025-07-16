package log_handler_cor;

import enums.LogLevel;

public class ErrorLogHandler extends LogHandler{
    public ErrorLogHandler() {
        super(LogLevel.ERROR);
    }

    @Override
    public void write(String message) {
         System.out.println("ERROR: " + message);
    }
}
