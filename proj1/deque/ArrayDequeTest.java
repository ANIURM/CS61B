package deque;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    // add some numbers and test get() method (iteration and recursion)
    public void getTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);
        lld.addLast(5);

        int i = lld.get(0);
        assertEquals(1, i);
        i = lld.get(1);
        assertEquals(2, i);
        i = lld.get(2);
        assertEquals(3, i);
        i = lld.get(3);
        assertEquals(4, i);
        i = lld.get(4);
        assertEquals(5, i);
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast((1));
        lld.addLast((2));
        lld.addLast((3));
        lld.addLast((4));
        lld.addLast((5));
        Iterator<Integer> test = lld.iterator();
        assertEquals(1, (int) test.next());
        assertEquals(2, (int) test.next());
        assertEquals(3, (int) test.next());
        assertEquals(4, (int) test.next());
        assertEquals(5, (int) test.next());
        assertFalse(test.hasNext());
    }

    @Test
    public void equalTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        lld.addLast(4);

        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        lld2.addLast(1);
        lld2.addLast(2);
        lld2.addLast(3);
        lld2.addLast(4);

        assertTrue(lld.equals(lld2));
        assertFalse(lld.equals(null));

        lld2.removeLast();
        assertFalse(lld.equals(lld2));
    }

    @Test
    public void Test005() {
        ArrayDeque<Integer> ts = new ArrayDeque<>();
        ts.addLast(0);
        assertEquals(0, (int) ts.removeFirst());
        assertTrue(ts.isEmpty());
        assertTrue(ts.isEmpty());
        ts.addLast(4);
        assertFalse(ts.isEmpty());
        assertEquals(4, (int) ts.removeFirst());
        ts.addLast(7);
        ts.removeFirst();
        ts.addLast(9);
        assertEquals(9, (int) ts.removeFirst());
    }

    @Test
    public void Test011() {
        ArrayDeque<Integer> ts = new ArrayDeque<>();
        ts.addLast(0);
        ts.addLast(1);
        assertEquals(0, (int)ts.get(0));
        ts.addLast(3);
        ts.get(0);
        ts.get(1);
        ts.get(1);
        ts.addFirst(7);
        ts.removeFirst();
        ts.get(0);
        ts.removeLast();
        ts.removeFirst();
        ts.removeFirst();
        ts.addLast(13);
        ts.get(0);
        ts.get(0);
        ts.addLast(16);
        ts.addLast(17);
        ts.removeLast();
        ts.removeLast();
        ts.removeFirst();
        ts.addLast(21);
        ts.get(0);
        ts.removeFirst();
    }

    @Test
    public void randomTest() {
        java.util.Deque<Integer> right = new java.util.ArrayDeque<Integer>();
        Deque<Integer> wrong = new ArrayDeque<>();

        int N = 50000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                //addFirst
                int randVal = StdRandom.uniform(0, 100);
                right.addFirst(randVal);
                wrong.addFirst(randVal);
            } else if (operationNumber == 1) {
                //remove last
                if (right.size() <= 0) {
                    continue;
                }
                assertEquals((int) right.removeLast(), (int) wrong.removeLast());
            } else {
                //isEmpty
                assertEquals(right.isEmpty(), wrong.isEmpty());
            }
        }
    }

    @Test
    public void randomGet() {
        Deque<Integer> wrong = new ArrayDeque<>();
        Deque<Integer> right = new LinkedListDeque<>();

        int N = 500000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                //addLast
                int randVal = StdRandom.uniform(0, 100);
                wrong.addLast(randVal);
                right.addLast(randVal);
            } else {
                //get
                if (right.isEmpty()) {
                    continue;
                }
                int randVal = StdRandom.uniform(0, right.size());
                assertEquals(wrong.get(randVal), right.get(randVal));
            }
        }
    }
}
