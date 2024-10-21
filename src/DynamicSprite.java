import java.awt.*;

public class DynamicSprite extends SolidSprite {
    protected Boolean isWalking = true;
    protected int speed = 5;
    protected final int spriteSheetNumberOfColumn = 10;
    protected int timeBetweenFrame = 200;
    protected Direction direction;

    public DynamicSprite(Image image, double x, double y, double width, double height) {
        super(image, x, y, width, height);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g) {
        int index = (int) ((System.currentTimeMillis())/timeBetweenFrame%spriteSheetNumberOfColumn);

        g.drawImage(image,(int) x, (int) y,(int) (width+x),(int) (height+y),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);
    }
}
