import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TowerOfHanoiGameTest {
    private TowerOfHanoiGame game_3x8;
    private TowerOfHanoiGame game_4x5;

    @Before
    public void setUp() {
        game_3x8 = new TowerOfHanoiGame(3, 8);
        game_4x5 = new TowerOfHanoiGame(4, 5);
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
}
