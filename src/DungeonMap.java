import java.io.BufferedReader ;
import java.io.FileNotFoundException;
import java.io.FileReader ;
import java.io.IOException;


public class DungeonMap {
    protected int width;
    protected int height;
    protected Tile[][] map;

    public DungeonMap(int width, int height, Tile[][] map) {
        this.width = width;
        this.height = height;
        this.map = map;
    }

    public Tile getTile(int x, int y) {
        return map[x][y];
    }

    public DungeonMap importMap(String mapName) {
        try {
            FileReader reader = new FileReader("./Maps/"+mapName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // Getting the MAP SIZE
            String line = bufferedReader.readLine();
            String[] strTab = line.split(";");
            int width = Integer.parseInt(strTab[0]);
            int height = Integer.parseInt(strTab[1]);
            Tile[][] map = new Tile[width][height];

            // Importing the MAP
            for (int y = 0; y < height; y++) {
                strTab = line.split(";");
                for (int x = 0; x < width; x++){
                    switch (strTab[x]){
                        case "W": map[x][y] = new Tile(x,y,TileType.WALL);
                        case " ": map[x][y] = new Tile(x,y,TileType.FLOOR);
                        case "O": map[x][y] = new Tile(x,y,TileType.WATER);
                        case "X": map[x][y] = new Tile(x,y,TileType.OBSTACLE);
                    }
                }
            }

            bufferedReader.close();
            reader.close();
        } catch (IOException importMap) {
            throw new RuntimeException(importMap);
        }
        return new DungeonMap(width, height, map);
    }

}
