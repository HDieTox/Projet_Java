public class Tile {
    protected int x;
    protected int y;
    protected TileType type;

    public Tile(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

enum TileType {
    WALL,
    FLOOR,
    WATER,
    OBSTACLE
}
