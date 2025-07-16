package log_handler_cor;

import enums.LogLevel;

public class InfoLogHandler extends LogHandler{
    public InfoLogHandler() {
        super(LogLevel.INFO);
    }

    @Override
    public void write(String message) {
         System.out.println("INFO: " + message);
    }
}
