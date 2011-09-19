import java.util.Iterator;
import java.util.NoSuchElementException;

public class Game implements Iterable<Tower> {
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

    Tower towerAt(int tower) {
        return towers[tower];
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

    public Iterator<Tower> iterator() {
        return new TowerIterator(this);
    }

    private class TowerIterator implements Iterator<Tower> {
        private Game game;
        private int currentTower;

        public TowerIterator(Game game) {
            this.game = game;
            this.currentTower = 0;
        }

        public boolean hasNext() {
            return this.currentTower < this.game.getNumberOfTowers();
        }

        public Tower next() {
            if (this.currentTower >= this.game.getNumberOfTowers())
                throw new NoSuchElementException();
            return this.game.towerAt(this.currentTower++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
