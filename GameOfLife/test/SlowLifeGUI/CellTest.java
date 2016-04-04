package SlowLifeGUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Meszar (jwm54@pitt.edu)
 */
public class CellTest {
    
    public CellTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Pinning test to make sure the optimized and original
     *      toString() method operate in the same expected manner.
     */
    @Test
    public void testToStringNewAndOld_One() {
        System.out.println("toStringNewAndOld_One: testing to make sure the old and new methods "
                + "return the same result for True...");
        
        Cell first = new Cell(true);
        Cell second = new Cell(true);
        
        String firstToString = first.toString();
        String secondToString = second.toString_OLD();
        
        assertEquals(firstToString, secondToString);
        
        System.out.println("toStringNewAndOld_One: Success!");
    }
    
    /**
     * Pinning test to make sure the optimized and original
     *      toString() method operate in the same expected manner.
     */
    @Test
    public void testToStringNewAndOld_Two() {
        System.out.println("toStringNewAndOld_Two: testing to make sure the old and new methods "
                + "return the same value for False...");
        
        Cell first = new Cell(false);
        Cell second = new Cell(false);
        
        String firstToString = first.toString();
        String secondToString = second.toString_OLD();
        
        assertEquals(firstToString, secondToString);
        
        System.out.println("toStringNewAndOld_Two: Success!");
    }
    
    /**
     * Pinning test to make sure the optimized and original
     *      toString() method operate in the same expected manner.
     */
    @Test
    public void testToStringOldAndNew_Three() {
        System.out.println("toStringNewAndOld_Three: testing to make sure the old and new methods "
                + "return the same value for true/false...");
        
        Cell first = new Cell(true);
        Cell second = new Cell(false);
        
        String firstToStringNew = first.toString();
        String firstToStringOld = first.toString_OLD();
        String secondToStringNew = second.toString();
        String secondToStringOld = second.toString_OLD();
        
        assertNotEquals(firstToStringNew, secondToStringNew);
        assertNotEquals(firstToStringOld, secondToStringOld);
        
        System.out.println("toStringNewAndOld_Three: Success!");
    }
}
