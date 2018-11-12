package Rover;

public class Rover {

    private Direction direction;

    public Rover(String startingDirection) {
        direction = Direction.facing(startingDirection);
    }

    public String executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.rotateRight();
            } else if (command == 'L') {
                direction = direction.rotateLeft();
            }
        }
        return "0 0 " + direction.facing();
    }

}
