package Rover;

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

    public static Direction facing(String startingDirection) {
       return match(startingDirection);
    }

    public Direction rotateRight() {
        return match(this.right);
    }

    public Direction rotateLeft() {
        return match(this.left);
    }

    private static Direction match(String from) {
        for (Direction newDirection : Direction.values()) {
            if (from.equals(newDirection.facing)) {
                return newDirection;
            }
        }
        throw new IllegalStateException("Incorrect configuration for the Rover direction");
    }
}
