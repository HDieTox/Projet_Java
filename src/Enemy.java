import java.awt.*;

public class Enemy extends DynamicTile {
    public Enemy(Image image, int x, int y, double width, double height, boolean isMoving, int scale, boolean fly) {
        super(image, x, y, width, height, isMoving, scale, fly);
    }

    public void yStrafe(){
        if(this.y < 100){
            this.direction = Direction.DOWN;
        } else if(this.y > 500){
            this.direction = Direction.UP;
        }
    }

    public void xStrafe(){
        if(this.x < 100){
            this.direction = Direction.RIGHT;
        } else if(this.x > 500){
            this.direction = Direction.LEFT;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
