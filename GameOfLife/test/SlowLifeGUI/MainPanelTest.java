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
public class MainPanelTest {
    int size = 15;
    MainPanel oldPanel = new MainPanel(size);
    MainPanel newPanel = new MainPanel(size);
 
        
    public MainPanelTest() {
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
     *      convertToInt() method operate in the same expected manner.
     */
    @Test
    public void testConvertToIntNewAndOld_One() {
        System.out.println("convertToIntNewAndOld_One: testing to make sure the old and new "
                + "methods return the same value...");

        MainPanel instance = new MainPanel(15);
        
        int expResult;
        int result;
        for (int i = 0; i < 5; i++) {
            result = instance.convertToInt(i);
            expResult = instance.convertToInt_OLD(i);

            assertEquals(expResult, result);
        }

        System.out.println("convertToIntNewAndOld_One: Success!");
    }
    
    /**
     * Pinning test to make sure the optimized and original
     *      convertToInt() method operate in the same expected manner.
     */
    @Test
    public void testConvertToIntNewAndOld_Two() {
        System.out.println("convertToIntNewAndOld_Two: testing to make sure the new "
                + "method accepts a negative number...");

        MainPanel instance = new MainPanel(15);
        
        int expResult=0;
        int result;
        for (int i = -1; i > -5; i--) {
            result = instance.convertToInt(i);
            
            try {
                expResult = instance.convertToInt_OLD(i);
            } catch (Exception e) {
                // expected!!
            }
            
            // should NOT be equal
            assertNotEquals(expResult, result);
        }

        System.out.println("convertToIntNewAndOld_Two: Success!");
    }
    
    /**
     * Pinning test to make sure the optimized and original
     *      convertToInt() method operate in the same expected manner.
     */
    @Test
    public void testConvertToIntNewAndOld_Three() {
        System.out.println("convertToIntNewAndOld_Three: testing to make sure the old and new "
                + "methods return the same value on MAX_INT...");

        MainPanel instance = new MainPanel(15);
        
        int expResult;
        int result;
        
        result = instance.convertToInt(Integer.MAX_VALUE);
        expResult = instance.convertToInt_OLD(Integer.MAX_VALUE);
        
        assertEquals(expResult, result);
        
        System.out.println("convertToIntNewAndOld_Three: Success!");
    }

    /**
     * Pinning test to make sure the optimized and original
     *      runContinous() method operate in the same expected manner.
     * 
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRunContinuousNewAndOld_One() throws InterruptedException {
        System.out.println("runContinuousNewAndOld_One: testing straight line with "
                + "new and old runContinous() method...");

        // set up the game to complete
        for (int i=0; i<15; i++) {
            oldPanel._cells[3][i].setAlive(true);
            newPanel._cells[3][i].setAlive(true);
        }
        
        // run the game(s)
        Thread oldThread = new Thread(new RunContinousOld());
        oldThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.oldPanel.stop();
        
        Thread newThread = new Thread(new RunContinous());
        newThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.newPanel.stop();
        
        // make sure all cells are the same
        assertEquals(oldPanel.toString(), newPanel.toString());
        
        // cleanup
        oldThread.stop();
        newThread.stop();
        
        System.out.println("runContinuousNewAndOld_One: Success!");
    }
    /**
     * Pinning test to make sure the optimized and original
     *      runContinous() method operate in the same expected manner.
     * 
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRunContinuousNewAndOld_Two() throws InterruptedException {
        System.out.println("runContinuousNewAndOld_Two: testing triangle pattern with "
                + "new and old runContinous() method...");

        // set up the game to complete
        oldPanel._cells[2][1].setAlive(true);
        newPanel._cells[2][1].setAlive(true);
        oldPanel._cells[3][0].setAlive(true);
        newPanel._cells[3][0].setAlive(true);
        oldPanel._cells[3][2].setAlive(true);
        newPanel._cells[3][2].setAlive(true);
        
        // run the game(s)
        Thread oldThread = new Thread(new RunContinousOld());
        oldThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.oldPanel.stop();
        
        Thread newThread = new Thread(new RunContinous());
        newThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.newPanel.stop();
        
        // make sure all cells are the same
        assertEquals(oldPanel.toString(), newPanel.toString());
        
        // cleanup
        oldThread.stop();
        newThread.stop();
        
        System.out.println("runContinuousNewAndOld_Two: Success!");
    }
    
    /**
     * Pinning test to make sure the optimized and original
     *      runContinous() method operate in the same expected manner.
     * 
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRunContinuousNewAndOld_Three() throws InterruptedException {
        System.out.println("runContinuousNewAndOld_Three: testing corner values with "
                + "new and old runContinous() method...");

        // set up the game to complete
        oldPanel._cells[0][0].setAlive(true);
        newPanel._cells[0][0].setAlive(true);
        oldPanel._cells[0][14].setAlive(true);
        newPanel._cells[0][14].setAlive(true);
        oldPanel._cells[14][0].setAlive(true);
        newPanel._cells[14][0].setAlive(true);
        oldPanel._cells[14][14].setAlive(true);
        newPanel._cells[14][14].setAlive(true);
        
        // run the game(s)
        Thread oldThread = new Thread(new RunContinousOld());
        oldThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.oldPanel.stop();
        
        Thread newThread = new Thread(new RunContinous());
        newThread.start();
        Thread.sleep(2000); // sleep 2sec to compute
        this.newPanel.stop();
        
        // make sure all cells are the same
        assertEquals(oldPanel.toString(), newPanel.toString());
        
        // cleanup
        oldThread.stop();
        newThread.stop();
        
        System.out.println("runContinuousNewAndOld_Three: Success!");
    }

    /**
     * Runnable thread; needed to test the runContinous() method.
     */
    class RunContinous implements Runnable {
        @Override
        public void run() {
            while (true) {
                newPanel.runContinuous();
            }
        }
    }
    
    /**
     * Runnable thread; needed to test the runContinous_OLD() method.
     */
    class RunContinousOld implements Runnable {
        @Override
        public void run() {
            while (true) {
                oldPanel.runContinuous_OLD();
            }
        }
    }
}
