import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;

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
        assertTrue(tower.pop() instanceof NullPiece);
        tower.add(new Piece(6));
        tower.add(new Piece(3));
        tower.add(new Piece(2));
        assertEquals(2, tower.pop().getSize());
        assertEquals(3, tower.pop().getSize());
        tower.add(new Piece(4));
        assertEquals(4, tower.pop().getSize());
        assertEquals(6, tower.pop().getSize());
        assertTrue(tower.pop() instanceof NullPiece);
    }

    @Test
    public void testIterator() {
        tower.add(new Piece(12));
        tower.add(new Piece(10));
        tower.add(new Piece(6));
        tower.add(new Piece(3));
        tower.add(new Piece(2));

        Iterator<Piece> iterator = tower.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(12, iterator.next().getSize());
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next().getSize());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next().getSize());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next().getSize());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().getSize());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() instanceof NullPiece);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() instanceof NullPiece);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() instanceof NullPiece);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.next() instanceof NullPiece);
        assertFalse(iterator.hasNext());
    }
}
