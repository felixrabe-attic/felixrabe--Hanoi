import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(in);
    private static Game game;

    public static void main(String[] args) {
        int nTowers = readInt("Number of towers", 3);
        int nPieces = readInt("Number of pieces", 6);
        game = new Game(nTowers, nPieces);
        while (true) {
            displayTowers();
            int fromTower = readInt("Tower to move from (99 to exit)", 99);
            if (fromTower == 99) {
                break;
            }
            int toTower = readInt("Tower to move to");
            printSomeEmptyLines();
            if (!game.movePiece(fromTower, toTower)) {
                out.println("THAT DID NOT WORK!");
            }
        }
    }

    private static int readInt(String prompt, int defaultInt) {
        out.print(prompt + " [" + defaultInt + "]: ");
        return readInt(defaultInt);
    }

    private static int readInt(String prompt) {
        out.print(prompt + ": ");
        return readInt(-1);
    }

    private static int readInt(int defaultInt) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return defaultInt;
        }
    }

    private static void displayTowers() {
        int nTowers = game.getNumberOfTowers();
        int nPieces = game.getNumberOfPieces();
        int[][] display = new int[nPieces][nTowers];

        for (int t = 0; t < nTowers; t++) {
            Tower tower = game.towerAt(t);
            for (int p = 0; p < nPieces; p++) {
                Piece piece = tower.pieceAt(p);
                display[nPieces - p - 1][t] = piece.getSize();
            }
        }

        out.println();
        for (int row = 0; row < nPieces; row++) {
            for (int column = 0; column < nTowers; column++) {
                int size = display[row][column];
                String padding = repeat(" ", nPieces - size);
                String parts = repeat("#", size);
                out.print(padding + parts + parts + padding + " ");
            }
            out.println();
        }
        for (int t = 0; t < nTowers; t++) {
            String padding = repeat(" ", nPieces);
            out.print(padding + t + padding);
        }
        out.println();
        out.println();
    }

    /**
     * Method to repeat a given string that many times.
     * Source: http://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java/4903603#4903603
     **/
    private static String repeat(String string, int times) {
        if (times == 0) return "";
        return new String(new char[times]).replace("\0", string);
    }

    private static void printSomeEmptyLines() {
        out.println();
        out.println();
        out.println();
        out.println();
        out.println();
    }
}
