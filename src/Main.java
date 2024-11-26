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
        frame.setLocationRelativeTo(null);

        DynamicTile hero = new DynamicTile(ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\heroTileSheetLowRes.png"))
                ,200,300,48,50,false, 1,false);
        Enemy dragon = new Enemy(ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\dragon.png"))
                ,465,75, 64,64,true,2, true);

        dragon.setDirection(Direction.LEFT);

        renderEngine = new RenderEngine();
        physicEngine = new PhysicEngine();
        gameEngine = new GameEngine(hero);

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer physicTimer = new Timer(50,(time)-> physicEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());

        renderTimer.start();
        physicTimer.start();
        gameTimer.start();



        DungeonMap map = new DungeonMap("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\data\\map1.txt");

        renderEngine.fullAddToRenderList(map.spritesToDisplayable());
        renderEngine.addToRenderList(hero);
        renderEngine.addToRenderList(dragon);
        physicEngine.addToSolidTilesList(map.getSolidSpritesList());
        physicEngine.addToMovingSprites(hero);
        physicEngine.addToMovingSprites(dragon);

        gameEngine.addToEnemyList(dragon);

        frame.getContentPane().add(renderEngine);
        frame.setVisible(true);

        frame.addKeyListener(gameEngine);
    }

    public static void main(String[] args){

        new TitleScreen();
    }
}