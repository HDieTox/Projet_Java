import java.util.ArrayList;

public class PhysicEngine implements Engine {
    private final ArrayList<DynamicTile> movingTilesList;
    private final ArrayList<Tile> solidTilesList;

    public PhysicEngine() {
        movingTilesList = new ArrayList<>();
        solidTilesList = new ArrayList<>();
    }

    public void addToMovingSprites(DynamicTile sprite) {
        if (!movingTilesList.contains(sprite)) {
            movingTilesList.add(sprite);
        }
    }

    public void addToSolidTilesList(ArrayList<Tile> tiles) {
        for (Tile tile : tiles) {
            if (!solidTilesList.contains(tile)) {
                solidTilesList.add(tile);
            }
        }
    }

    @Override
    public void update() {
        for (DynamicTile dynamicSprite : movingTilesList) {
            dynamicSprite.moveIfPossible(solidTilesList);
        }
    }
}
