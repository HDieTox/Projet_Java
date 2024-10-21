import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    JFrame frame;

    RenderEngine renderEngine;

    public Main() throws Exception {
        frame = new JFrame("Java Project");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        renderEngine = new RenderEngine(frame);



        DynamicSprite hero = new DynamicSprite(ImageIO.read(new File("./img/heroTileSheetLowRes.png")),
                200,300,48,50);
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