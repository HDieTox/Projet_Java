import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener {
    DynamicSprite hero;

    public GameEngine(DynamicSprite hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                hero.isMoving = true;
                hero.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                hero.isMoving = true;
                hero.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                hero.isMoving = true;
                hero.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                hero.isMoving = true;
                hero.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_CONTROL:
                hero.speed = 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT:
                hero.isMoving = false;
                break;
            case KeyEvent.VK_CONTROL:
                hero.speed = 5;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void update() {}


}
