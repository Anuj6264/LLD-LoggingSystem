package log_handler_cor;

import enums.LogLevel;

public class DebugLogHandler extends LogHandler{
    public DebugLogHandler() {
        super(LogLevel.DEBUG);
    }

    @Override
    public void write(String message) {
         System.out.println("DEBUG: " + message);
    }
}
