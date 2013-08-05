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
    private static int iterations;


    public static int getIterations() {
        return iterations;
    }

    public static double getSquareRootBinarySearch(double target) {
        return getSquareRootBinarySearch(target, PRECISION);
    }


    public static double getSquareRootBinarySearch(double target, double precision) {
        iterations = 0;
        if (target == 0 || target==1) return target;
        if (target<0) return -1;


        double start=0;
        double end=target;


        if (target<1)
            end = 1;


        while((end-start)>precision) {
            double mid = (start+end)/2;
            double newTarget = mid * mid;
            if (newTarget==target) return mid;
            if (newTarget>target)
                end = mid;
            else
                start = mid;
            iterations++;
        }

        return (start+end)/2;
    }


    public static void main(String[] args) {
        System.out.println("BS Square Root: 500 (0.0000000001): = " + getSquareRootBinarySearch(500, 0.0000000001));
        System.out.println("Iterations: "+getIterations());
        System.out.println("BS Square Root: 500 (0.0000000001): = " + getSquareRootNewton(500, 0.0000000001));
        System.out.println("Iterations: "+getIterations());

    }

    public static double getSquareRootNewton(double target) {
        return getSquareRootBinarySearch(target, PRECISION);
    }


    public static double getSquareRootNewton(double target, double precision) {
        iterations = 0;
        if (target == 0 || target==1) return target;
        if (target<0) return -1;
        double x = 10;
        while (Math.abs(target-x*x)>precision) {
            x = x - (x*x-target)/2/x;
            iterations++;
        }
        return x;
    }
}