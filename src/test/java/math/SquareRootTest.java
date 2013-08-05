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

    private double TEST_PRECISION = 1e-10;

    public void testGetSquareRoot_simpleCases() throws Exception {
        assertEquals(SquareRoot.getSquareRootBinarySearch(0), 0.0);
        assertEquals(SquareRoot.getSquareRootBinarySearch(1), 1.0);

        assertEquals(SquareRoot.getSquareRootBinarySearch(-10), -1.0);

    }

    public void testGetSquareRoot_simpleCases_greaterThen1_integers() throws Exception {
        double precision = TEST_PRECISION;
        assertEquals(2.0, SquareRoot.getSquareRootBinarySearch(2.0 * 2.0, precision), precision );
        assertEquals(4.0, SquareRoot.getSquareRootBinarySearch(4.0 * 4.0, precision), precision );
        assertEquals(3.0, SquareRoot.getSquareRootBinarySearch(3.0 * 3.0, precision), precision );

        assertEquals(5.0, getSquareRootBinarySearch(5.0 * 5.0, precision), precision);
    }

    public void testGetSquareRoot_simpleCases_greaterThen1_real() throws Exception {
        double precision = TEST_PRECISION;
        assertEquals(1.5, getSquareRootBinarySearch(1.5 * 1.5, precision), precision);
        assertEquals(2.5, getSquareRootBinarySearch(2.5 * 2.5, precision), precision);

        assertEquals(11.11, getSquareRootBinarySearch(11.11 * 11.11, precision), precision);
    }

    public void testGetSquareRoot_simpleCases_lessThen1_real() throws Exception {
        double precision = TEST_PRECISION;
        assertEquals(0.25, getSquareRootBinarySearch(0.25 * 0.25, precision), precision);
        assertEquals(0.125, getSquareRootBinarySearch(0.125 * 0.125, precision), precision);

        assertEquals(0.11, getSquareRootBinarySearch(0.11 * 0.11, precision), precision);
    }


    public void testGetSquareRootN_simpleCases() throws Exception {
        assertEquals(SquareRoot.getSquareRootNewton(0), 0.0);
        assertEquals(SquareRoot.getSquareRootNewton(1), 1.0);

        assertEquals(SquareRoot.getSquareRootBinarySearch(-10), -1.0);

    }

    public void testGetSquareRootN_simpleCases_greaterThen1_integers() throws Exception {
        double precision = TEST_PRECISION;
        assertEquals(2.0, SquareRoot.getSquareRootNewton(2.0 * 2.0, precision), precision );
        assertEquals(4.0, SquareRoot.getSquareRootNewton(4.0 * 4.0, precision), precision );
        assertEquals(3.0, SquareRoot.getSquareRootNewton(3.0 * 3.0, precision), precision );

        assertEquals(5.0, SquareRoot.getSquareRootNewton(5.0 * 5.0, precision), precision);
    }

    public void testGetSquareRootN_simpleCases_greaterThen1_real() throws Exception {

        double precision = TEST_PRECISION;
        assertEquals(1.5, SquareRoot.getSquareRootNewton(1.5 * 1.5, precision), precision);
        assertEquals(2.5, SquareRoot.getSquareRootNewton(2.5 * 2.5, precision), precision);

        assertEquals(11.11, SquareRoot.getSquareRootNewton(11.11 * 11.11, precision), precision);
    }

    public void testGetSquareRootN_simpleCases_lessThen1_real() throws Exception {
        //newton method uses precision to compare square of the number
        //to make assertEquals work we should use square root of precision
        double precision = 1e-15;
        double assertPrecision = 1e-8;

        assertEquals(0.25, SquareRoot.getSquareRootNewton(0.25 * 0.25, precision), assertPrecision);
        assertEquals(0.125, SquareRoot.getSquareRootNewton(0.125 * 0.125, precision), assertPrecision);

        assertEquals(0.11, SquareRoot.getSquareRootNewton(0.11 * 0.11, precision), assertPrecision);
    }


}
