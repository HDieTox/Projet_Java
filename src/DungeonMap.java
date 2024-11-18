import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader ;
import java.io.File;
import java.io.FileReader ;
import java.io.IOException;
import java.util.ArrayList;


public class DungeonMap {
    protected int width;
    protected int height;
    protected ArrayList<Tile> map;

    public Tile getTile(int x, int y) {
        return map.get(y*width+x);
    }

    public DungeonMap() {
        try {
            Image imageTree = ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\tree.png"));
            Image imageGrass = ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\grass.png"));
            Image imageRock = ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\rock.png"));
            Image imageWater = ImageIO.read(new File("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\img\\water.png"));

            int imageTreeWidth = imageTree.getWidth(null);
            int imageTreeHeight = imageTree.getHeight(null);

            int imageGrassWidth = imageGrass.getWidth(null);
            int imageGrassHeight = imageGrass.getHeight(null);

            int imageRockWidth = imageRock.getWidth(null);
            int imageRockHeight = imageRock.getHeight(null);

            int imageWaterWidth = imageWater.getWidth(null);
            int imageWaterHeight = imageWater.getHeight(null);

            FileReader reader = new FileReader("C:\\Users\\tomco\\IdeaProjects\\Projet_Java\\src\\data\\map1.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            // Getting the MAP SIZE
            String line = bufferedReader.readLine();
            String[] strTab = line.split(";");
            int width = Integer.parseInt(strTab[0]);
            int height = Integer.parseInt(strTab[1]);
            ArrayList<Tile> map = new ArrayList<>();

            // Importing the MAP
            for (int y = 0; y < height; y++) {
                line = bufferedReader.readLine();
                for (int x = 0; x < width; x++) {
                    switch (line.toCharArray()[x]) {
                        case 'W':
                            map.add(new Tile(imageTree,x,y,imageTreeWidth,imageTreeHeight,2));
                            break;
                        case ' ':
                            map.add(new Tile(imageGrass,x,y,imageGrassWidth,imageGrassHeight,0));
                            break;
                        case 'O':
                            map.add(new Tile(imageWater,x,y,imageWaterWidth,imageWaterHeight,1));
                            break;
                        case 'X':
                            map.add(new Tile(imageRock,x,y,imageRockWidth,imageRockHeight,1));
                            break;
                    }
                }
            }

            bufferedReader.close();
            reader.close();

            this.map = map;
            this.width = width;
            this.height = height;
        } catch (IOException importMap) {
            throw new RuntimeException(importMap);
        }
    }

    public ArrayList<Tile> getSpritesList() {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Tile myTile = getTile(x,y);
                tiles.add(myTile);
            }
        }
        return tiles;
    }

    public ArrayList<Displayable> spritesToDisplayable(){
        return new ArrayList<>(this.getSpritesList());
    }

    public ArrayList<Tile> getSolidSpritesList(){
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Tile tile : this.getSpritesList()) {
            if (tile.scale > 0) tiles.add(tile);
            }
        return tiles;
    }
}
