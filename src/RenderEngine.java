import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine {
    private final ArrayList<Displayable> renderList;

    public RenderEngine() {
        this.renderList = new ArrayList<>();
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    public void fullAddToRenderList(ArrayList<Displayable> displayable){
        for (Displayable displayableElement : displayable){
            addToRenderList(displayableElement);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Displayable displayable : renderList){
            displayable.draw(g);
        }
    }

    public void update(){
        repaint();
    }
}
