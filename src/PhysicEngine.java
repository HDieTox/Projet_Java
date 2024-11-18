import java.util.ArrayList;

public class PhysicEngine implements Engine {
    private final ArrayList<DynamicSprite> movingTilesList;
    private final ArrayList<Tile> solidTilesList;

    public PhysicEngine() {
        movingTilesList = new ArrayList<>();
        solidTilesList = new ArrayList<>();
    }

    public void addToMovingSprites(DynamicSprite sprite) {
        if (!movingTilesList.contains(sprite)) {
            movingTilesList.add(sprite);
        }
    }

    public void addToSolidTilesList(ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            if (!solidTilesList.contains(tile)) {
                solidTilesList.add(tile);
                System.out.println(tile.x + " " + tile.y);
            }
        }
    }

    @Override
    public void update() {
        for (DynamicSprite dynamicSprite : movingTilesList) {
            dynamicSprite.moveIfPossible(solidTilesList);
        }
    }
}