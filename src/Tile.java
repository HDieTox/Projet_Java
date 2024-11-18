import java.awt.*;

public class Tile implements Displayable {
    protected Image image;
    protected int x;
    protected int y;
    protected double width;
    protected double height;
    protected int scale;

    public Tile(Image image, int x, int y, double width, double height,int scale) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) (x*width), (int) (y*height), null);
    }
}