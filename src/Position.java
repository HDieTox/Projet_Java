public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public Position move(Direction direction) {
        return switch (direction) {
            case UP -> new Position(x, y + 1);
            case DOWN -> new Position(x, y - 1);
            case LEFT -> new Position(x - 1, y);
            case RIGHT -> new Position(x + 1, y);
        };
    }
}

enum Direction {
    UP,DOWN,LEFT,RIGHT;
}
