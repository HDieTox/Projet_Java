import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicTile extends SolidTile {
    protected boolean isMoving;
    protected int speed = 5;
    protected final int spriteSheetNumberOfColumn = 10;
    protected int timeBetweenFrame = 200;
    protected Direction direction = Direction.UP;
    protected boolean fly;

    public DynamicTile(Image image, int x, int y, double width, double height, boolean isMoving, int scale, boolean fly) {
        super(image, x, y, width, height, scale);
        this.isMoving = isMoving;
        this.fly = fly;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private boolean isMovingPossible(ArrayList<Tile> tiles){
        if (!this.isMoving) {
            return false;
        }else {
            Rectangle2D.Double moved = new Rectangle2D.Double();
            switch(direction){
                case RIGHT: moved.setRect(super.getHitBox().getX()+speed,super.getHitBox().getY(),
                        super.getHitBox().getWidth(), super.getHitBox().getHeight());
                    break;
                case LEFT:  moved.setRect(super.getHitBox().getX()-speed,super.getHitBox().getY(),
                        super.getHitBox().getWidth(), super.getHitBox().getHeight());
                    break;
                case UP:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()-speed,
                        super.getHitBox().getWidth(), super.getHitBox().getHeight());
                    break;
                case DOWN:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()+speed,
                        super.getHitBox().getWidth(), super.getHitBox().getHeight());
                    break;
            }

            for (Tile t : tiles){
                if ((this.scale > 0) && (t!=this)){
                    if (intersect(t,moved)){
                        return t.scale < 2 && this.fly;
                    }
                }
            }
            return true;
        }
    }


    private void move(){
        switch (direction) {
            case UP:
                this.y -= speed;
                break;
            case DOWN:
                this.y += speed;
                break;
            case LEFT:
                this.x -= speed;
                break;
            case RIGHT:
                this.x += speed;
                break;
        }
    }

    public void moveIfPossible(ArrayList<Tile> tiles) {
        if (isMovingPossible(tiles)){
            move();
        }
    }

    @Override
    public void draw(Graphics g) {
        int index;
        if (this.isMoving){
            index = (int) ((System.currentTimeMillis())/timeBetweenFrame%spriteSheetNumberOfColumn);
        }else{
            index = 0;
        }

        g.drawImage(image, x, y,(int) (width+x),(int) (height+y),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);
    }
}
