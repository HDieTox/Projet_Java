import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SolidSprite extends Tile {

    public SolidSprite(Image image, int x, int y, double width, double height, int scale) {
        super(image, x, y, width, height,scale);
    }

    public Rectangle2D getHitBox() {
        return new Rectangle2D.Double(this.x,this.y,this.width,this.height);
    }

    public Rectangle2D getHitBox(Tile tile) {
        return new Rectangle2D.Double(tile.x,tile.y, tile.width, tile.height);
    }

    public boolean intersect(Tile tile,Rectangle2D.Double hitBox){
        return getHitBox(tile).intersects(hitBox);
    }
}
