public class Game {
    private Tower[] towers;

    public Game(int numberOfTowers, int numberOfPieces) {
        if (numberOfTowers < 1 || numberOfPieces < 1) {
            return;
        }
        towers = new Tower[numberOfTowers];
        for (int i = 0; i < towers.length; i++) {
            towers[i] = new Tower(numberOfPieces);
        }
        for (int size = towers[0].getMaxHeight(); size > 0; size--) {
            Piece piece = new Piece(size);
            towers[0].add(piece);
        }
    }

    public Game(int numberOfPieces) {
        this(3, numberOfPieces);
    }

    public int getNumberOfTowers() {
        return towers.length;
    }

    public int getNumberOfPieces() {
        return towers[0].getMaxHeight();
    }

    public boolean /* successful? */ movePiece(int fromTower, int toTower) {
        if (towerNumberOutOfBounds(fromTower) || towerNumberOutOfBounds(toTower)) {
            return false;
        }
        Piece piece = towers[fromTower].pop();
        boolean successful = towers[toTower].add(piece);
        if (!successful) {
            towers[fromTower].add(piece);  // put it back
        }
        return successful;
    }

    private boolean towerNumberOutOfBounds(int towerNumber) {
        return towerNumber < 0 || towerNumber >= getNumberOfTowers();
    }
}
