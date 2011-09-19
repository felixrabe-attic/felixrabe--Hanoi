import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TowerTest {
    private Tower tower;

    @Before
    public void setUp() {
        tower = new Tower(9);
    }

    @Test
    public void testAdd() {
        assertTrue("First piece, size 4", tower.add(new Piece(4)));
        assertFalse("Cannot add piece of size 6 on piece of size 4", tower.add(new Piece(6)));
        assertTrue("Can add piece of size 3 on piece of size 4", tower.add(new Piece(3)));
    }

    @Test
    public void testPop() {
        assertNull(tower.pop());
        tower.add(new Piece(6));
        tower.add(new Piece(3));
        tower.add(new Piece(2));
        assertEquals(2, tower.pop().getSize());
        assertEquals(3, tower.pop().getSize());
        tower.add(new Piece(4));
        assertEquals(4, tower.pop().getSize());
        assertEquals(6, tower.pop().getSize());
        assertNull(tower.pop());
    }
}
