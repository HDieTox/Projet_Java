import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class Main {
    JFrame frame;

    RenderEngine renderEngine;

    public Main() throws Exception {
        frame = new JFrame("Java Project");
        frame.setSize(650,650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        renderEngine = new RenderEngine(frame);

        File fyle = new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\heroTileSheetLowRes.png");
        DungeonMap map = new DungeonMap("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\data\\map1.txt");

        DynamicSprite hero = new DynamicSprite(ImageIO.read(fyle),200,300,48,50);

        renderEngine.fullAddToRenderList(map.spritesToDisplayables());
        renderEngine.addToRenderList(hero);


        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());

        renderTimer.start();

        frame.getContentPane().add(renderEngine);
        frame.setVisible(true);

    }

    public static void main(String[] args)  throws Exception{
        Main main = new Main();
    }
}