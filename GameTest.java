import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private Game game_3x8;
    private Game game_4x5;

    @Before
    public void setUp() {
        game_3x8 = new Game(3, 8);
        game_4x5 = new Game(4, 5);
    }

    @Test
    public void testGetNumberOfTowers() {
        assertEquals(3, game_3x8.getNumberOfTowers());
        assertEquals(4, game_4x5.getNumberOfTowers());
    }

    @Test
    public void testGetNumberOfPieces() {
        assertEquals(8, game_3x8.getNumberOfPieces());
        assertEquals(5, game_4x5.getNumberOfPieces());
    }

    @Test
    public void testThreeTowersIsDefault() {
        Game game_x2 = new Game(2);
        Game game_x99 = new Game(99);
        assertEquals(3, game_x2.getNumberOfTowers());
        assertEquals(3, game_x99.getNumberOfTowers());
    }

    @Test
    public void testMovePiece() {
        assertEquals(3, game_3x8.getNumberOfTowers());
        assertEquals(8, game_3x8.getNumberOfPieces());
        // 87654321 - -
        assertTrue(game_3x8.movePiece(0, 2));
        // 8765432 - 1
        assertTrue(game_3x8.movePiece(0, 1));
        // 876543 2 1
        assertFalse(game_3x8.movePiece(1, 2));
        // 876543 2 1
        assertTrue(game_3x8.movePiece(2, 1));
        // 876543 21 -
        assertTrue(game_3x8.movePiece(0, 2));
        // 87654 21 3
        assertTrue(game_3x8.movePiece(1, 0));
        // 876541 2 3
        assertTrue(game_3x8.movePiece(1, 2));
        // 876541 - 32
        assertTrue(game_3x8.movePiece(0, 2));
        // 87654 - 321
    }

    @Test
    public void testInvalidMoves() {
        assertEquals(3, game_3x8.getNumberOfTowers());
        assertFalse(game_3x8.movePiece(0, 3));  // last tower is 2
        assertFalse(game_3x8.movePiece(1, 0));  // tower 1 has no piece
        assertTrue(game_3x8.movePiece(0, 1));
        assertFalse(game_3x8.movePiece(0, 1));  // piece has to be smaller
        assertFalse(game_3x8.movePiece(1, -1));  // first tower is 0
    }
}
