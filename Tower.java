public class Tower {
    private Piece[] pieces;
    private int height;

    public Tower(int maxHeight) {
        pieces = new Piece[maxHeight];
        height = 0;
    }

    public int getMaxHeight() {
        return pieces.length;
    }

    public boolean /* successful? */ add(Piece newPiece) {
        if (towerIsFull()) {
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
            return null;
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
}
