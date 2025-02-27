package bridge.domain;

import java.util.Arrays;

import static bridge.exception.ExceptionMessage.*;

public enum Position {
    UP("U", 1),
    DOWN("D", 0);

    private final String command;
    private final int value;

    Position(String command, int value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public static String getCommandByValue(int value) {
        return Arrays.stream(Position.values())
                .filter(position -> position.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_POSITION_VALUE_EXCEPTION.getMessage()))
                .command;
    }

    public static Position getPositionByCommand(String command) {
        return Arrays.stream(Position.values())
                .filter(position -> position.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_POSITION_COMMAND_EXCEPTION.getMessage()));
    }
}
