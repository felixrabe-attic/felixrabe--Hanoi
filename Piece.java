public class Piece {
    private int size;

    public Piece(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be at least 1.");
        }
        this.size = size;
    }

    Piece() {  // called by NullPiece
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
}
