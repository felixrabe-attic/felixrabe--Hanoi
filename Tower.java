import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tower implements Iterable<Piece> {
    private Piece[] pieces;
    private int height;

    public Tower(int maxHeight) {
        pieces = new Piece[maxHeight];
        height = 0;
    }

    public int getMaxHeight() {
        return pieces.length;
    }

    Piece pieceAt(int height) {
        if (height < this.height) {
            return pieces[height];
        } else {
            return new NullPiece();
        }
    }

    public boolean /* successful? */ add(Piece newPiece) {
        if (newPiece instanceof NullPiece) {
            return false;
        } else if (towerIsFull()) {
            return false;
        } else if (thereIsNoPieceYet() || newPieceIsSmallerThanTopPiece(newPiece)) {
            this.pieces[height++] = newPiece;
            return true;
        } else {
            return false;
        }
    }

    public Piece pop() {
        if (thereIsNoPieceYet()) {
            return new NullPiece();
        } else {
            return pieces[--height];
        }
    }

    private boolean towerIsFull() {
        return height == getMaxHeight();
    }

    private boolean thereIsNoPieceYet() {
        return height == 0;
    }

    private boolean newPieceIsSmallerThanTopPiece(Piece newPiece) {
        return pieces[height-1].getSize() > newPiece.getSize();
    }

    public Iterator<Piece> iterator() {
        return new PieceIterator(this);
    }

    private class PieceIterator implements Iterator<Piece> {
        private Tower tower;
        private int currentHeight;

        public PieceIterator(Tower tower) {
            this.tower = tower;
            this.currentHeight = 0;
        }

        public boolean hasNext() {
            return this.currentHeight < this.tower.getMaxHeight();
        }

        public Piece next() {
            if (this.currentHeight >= this.tower.getMaxHeight())
                throw new NoSuchElementException();
            return this.tower.pieceAt(this.currentHeight++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
