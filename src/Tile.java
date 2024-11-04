import java.awt.*;

public class Tile {
    protected int x;
    protected int y;
    protected Image type;

    public Tile(int x, int y, Image type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
