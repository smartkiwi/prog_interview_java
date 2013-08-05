package math;

import junit.framework.TestCase;

import static math.SquareRoot.getSquareRootBinarySearch;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 8/5/13
 * Time: 10:37 AM
 * Test cases for calculating square root
 */
public class SquareRootTest extends TestCase {
    public void testGetSquareRoot_simpleCases() throws Exception {
        assertEquals(SquareRoot.getSquareRootBinarySearch(0), 0.0);
        assertEquals(SquareRoot.getSquareRootBinarySearch(1), 1.0);

        assertEquals(SquareRoot.getSquareRootBinarySearch(-10), -1.0);

    }

    public void testGetSquareRoot_simpleCases_greaterThen1_integers() throws Exception {
        double precision = 0.00001;
        assertEquals(2.0, SquareRoot.getSquareRootBinarySearch(2.0 * 2.0), precision );
        assertEquals(4.0, SquareRoot.getSquareRootBinarySearch(4.0 * 4.0), precision );
        assertEquals(3.0, SquareRoot.getSquareRootBinarySearch(3.0 * 3.0), precision );

        assertEquals(5.0, getSquareRootBinarySearch(5.0 * 5.0, precision), precision);
    }

    public void testGetSquareRoot_simpleCases_greaterThen1_real() throws Exception {
        double precision = 0.000001;
        assertEquals(1.5, getSquareRootBinarySearch(1.5 * 1.5, precision), precision);
        assertEquals(2.5, getSquareRootBinarySearch(2.5 * 2.5, precision), precision);

        assertEquals(11.11, getSquareRootBinarySearch(11.11 * 11.11, precision), precision);
    }

}
