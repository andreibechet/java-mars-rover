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

    public enum Direction {
        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        SOUTH("S", "E", "W"),
        WEST("W", "S", "N");

        private final String facing;
        private final String left;
        private final String right;

        Direction(String facing, String left, String right) {
            this.facing = facing;
            this.left = left;
            this.right = right;
        }

        public String facing() {
            return facing;
        }

        public Direction rotateRight() {
            for (Direction newDirection : Direction.values()) {
                if (this.right.equals(newDirection.facing)) {
                    return newDirection;
                }
            }
            throw new IllegalStateException("Incorrect configuration for the Rover direction");
        }

        public Direction rotateLeft() {
            for (Direction newDirection : Direction.values()) {
                if (this.left.equals(newDirection.facing)) {
                    return newDirection;
                }
            }
            throw new IllegalStateException("Incorrect configuration for the Rover direction");
        }

        public static Direction facing(String startingDirection) {
            for (Direction direction : Direction.values()) {
                if (direction.facing.equals(startingDirection)) {
                    return direction;
                }
            }
            throw new IllegalStateException("Incorrect configuration for the Rover direction");
        }
    }
}
