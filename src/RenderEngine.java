import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderEngine {
    private ArrayList<Displayable> renderList;

    public RenderEngine(JFrame jFrame) {
        this.renderList = new ArrayList<>();
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }

    public void update(){

    }
}
