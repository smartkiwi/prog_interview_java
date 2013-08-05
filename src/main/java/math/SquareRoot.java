package math;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 8/5/13
 * Time: 10:35 AM
 * Calculate Square Root for the real number without using special methods
 */
public class SquareRoot {
    private static final double PRECISION = 0.0000001;

    public static double getSquareRootBinarySearch(double target) {
        return getSquareRootBinarySearch(target, PRECISION);
    }

    public static double getSquareRootBinarySearch(double target, double precision) {
        if (target == 0 || target==1) return target;
        if (target<0) return -1;


        double start=0;
        double end=target;
        double mid = 0;


        while((end-start)>precision) {
            mid = (start+end)/2;
            double newTarget = mid * mid;
            if (newTarget==target) return mid;
            if (newTarget>target)
                end = mid;
            else
                start = mid;
        }

        return mid;
    }
}
