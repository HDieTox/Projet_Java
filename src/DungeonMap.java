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
    protected Tile[][] map;

    public Tile getTile(int x, int y) {
        return map[x][y];
    }

    public DungeonMap(String mapName) {
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
            Tile[][] map = new Tile[width][height];

            // Importing the MAP
            for (int y = 0; y < height; y++) {
                line = bufferedReader.readLine();
                for (int x = 0; x < width; x++) {
                    switch (line.toCharArray()[x]) {
                        case 'W':
                            map[x][y] = new Tile(x, y, imageTree);
                            break;
                        case ' ':
                            map[x][y] = new Tile(x, y, imageGrass);
                            break;
                        case 'O':
                            map[x][y] = new Tile(x, y, imageWater);
                            break;
                        case 'X':
                            map[x][y] = new Tile(x, y, imageRock);
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

    public ArrayList<Sprite> getSpritesList() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Image myTile = getTile(x,y).type;
                int myTileWidth = myTile.getWidth(null);
                int myTileHeight = myTile.getHeight(null);
                sprites.add(new SolidSprite(myTile,x*myTileWidth,y*myTileHeight,myTileWidth,myTileHeight));
            }
        }
        return sprites;
    }

    public ArrayList<Displayable> spritesToDisplayables(){
        ArrayList <Displayable> displayableArrayList = new ArrayList<>();
        for (Sprite sprite : this.getSpritesList()){
            displayableArrayList.add((Displayable) sprite);
        }
        return displayableArrayList;
    }
}