package enums;

public enum LogLevel {
    DEBUG(1),
    INFO(2),
    ERROR(3);

    private int value;
    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
