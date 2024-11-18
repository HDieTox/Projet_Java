import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class Main {
    JFrame frame;

    RenderEngine renderEngine;
    PhysicEngine physicEngine;
    GameEngine gameEngine;

    public Main() throws Exception {
        frame = new JFrame("Java Project");
        frame.setSize(650,650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        DynamicSprite hero = new DynamicSprite(ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\heroTileSheetLowRes.png"))
                ,200,300,48,50,false, 1);

        renderEngine = new RenderEngine();
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer physicTimer = new Timer(50,(time)-> physicEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());

        renderTimer.start();
        physicTimer.start();
        gameTimer.start();

        frame.getContentPane().add(renderEngine);
        frame.setVisible(true);

        DungeonMap map = new DungeonMap("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\data\\map1.txt");

        renderEngine.fullAddToRenderList(map.spritesToDisplayable());
        renderEngine.addToRenderList(hero);
        physicEngine.addToSolidTilesList(map.getSolidSpritesList());
        physicEngine.addToMovingSprites(hero);

        frame.addKeyListener(gameEngine);
    }

    public static void main(String[] args)  throws Exception{
        Main main = new Main();
    }
}