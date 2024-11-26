import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Projectile extends DynamicTile {
    protected Direction direction;
    protected int speed;


    public Projectile(Image image, int x, int y, double width, double height, boolean isMoving, int scale, boolean fly, Direction direction, int speed) {
        super(image, x, y, width, height, isMoving, scale, fly);
        this.direction = direction;
        this.speed = speed;
    }
/*
    public void ThrowArrow() throws IOException {
        Image imgArrow = ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\arrow.png"));
        //Projectile arrow = new Projectile(imgArrow,this.x, this.y);
    }

 */


}
