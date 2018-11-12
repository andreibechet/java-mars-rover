package Rover;

import java.util.Objects;

public class Rover {
    public String executeCommands(String commands) {
        String direction = "N";
        for (char command : commands.toCharArray()) {

            if (command == 'R') {
                direction = rotateRight(direction);
            }
        }
        return "0 0 " + direction;
    }

    private String rotateRight(String direction) {
        if (Objects.equals(direction, "N")) {
            direction = "E";
        } else if (Objects.equals(direction, "S")) {
            direction = "W";
        } else if (Objects.equals(direction, "W")) {
            direction = "N";
        } else {
            direction = "S";
        }
        return direction;
    }
}
