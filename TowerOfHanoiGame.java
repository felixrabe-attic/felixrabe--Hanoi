public class TowerOfHanoiGame {
    private Tower[] towers;

    public TowerOfHanoiGame(int numberOfTowers, int numberOfPieces) {
        towers = new Tower[numberOfTowers];
        for (int i = 0; i < towers.length; i++) {
            towers[i] = new Tower(numberOfPieces);
        }
        for (int size = towers[0].getMaxHeight(); size > 0; size--) {
            Piece piece = new Piece(size);
            towers[0].add(piece);
        }
    }

    public TowerOfHanoiGame(int numberOfPieces) {
        this(3, numberOfPieces);
    }

    public int getNumberOfTowers() {
        return towers.length;
    }

    public int getNumberOfPieces() {
        return towers[0].getMaxHeight();
    }

    public boolean /* successful? */ movePiece(int fromTower, int toTower) {
        Piece piece = towers[fromTower].pop();
        boolean successful = towers[toTower].add(piece);
        if (!successful) {
            towers[fromTower].add(piece);  // put it back
        }
        return successful;
    }
}
