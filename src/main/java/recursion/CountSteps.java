package recursion;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/14/13
 * Time: 12:04 PM
 * Counts the number of ways N stairs can be hopped over by 1,2,3 stair steps
 * three versions:
 *  recursion (slow)
 *  Dynamic Programming - recursion and cache (fast but overflows)
 *  DP using BigInteger object - fast and doesn't overflows
 */
public class CountSteps {

    public static long countSteps(int n) {
        if (n<0)
            return 0;
        if (n==0)
            return 1;
        return countSteps(n - 3)+ countSteps(n - 2)+ countSteps(n - 1);
    }


    public static long countStepsIterative(int n) {
        if (n<0)
            return 0;
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        if (n==3)
            return 4;
        int[] prev = {1,2,4};
        int current = 3;
        while(current<n) {
            int nextValue = prev[0]+prev[1]+prev[2];
            prev[0]=prev[1];
            prev[1]=prev[2];
            prev[2]=nextValue;
            current++;
        }
        return prev[2];
    }


    public static long countStepsDP(int n, long[] map) {
        if (n<0)
            return 0;
        if (n==0)
            return 1;
        if (map[n]>-1)
            return map[n];
        else {
            map[n] = countStepsDP(n - 3, map)+ countStepsDP(n - 2, map)+ countStepsDP(n - 1, map);
            return map[n];
        }
    }

    public static BigInteger countStepsDPBI(int n, BigInteger[] map) {
        if (n<0)
            return BigInteger.valueOf(0);
        if (n==0)
            return BigInteger.valueOf(1);
        if (map[n].compareTo(BigInteger.valueOf(-1))==1)
            return map[n];
        else {
            BigInteger sum = BigInteger.valueOf(0);
            sum = sum.add(countStepsDPBI(n - 3, map)).add(countStepsDPBI(n - 2, map)).add(countStepsDPBI(n - 1, map));
            map[n] = sum;
            return map[n];
        }
    }


    public static BigInteger countStepsIterativeBI(int n) {
        if (n<0)
            return BigInteger.valueOf(0);
        if (n==0)
            return BigInteger.valueOf(0);
        if (n==1)
            return BigInteger.valueOf(1);
        if (n==2)
            return BigInteger.valueOf(2);
        if (n==3)
            return BigInteger.valueOf(4);
        BigInteger[] prev = {BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(4)};
        int current = 3;
        while (current<n) {
            BigInteger nextValue = BigInteger.valueOf(0).add(prev[0]).add(prev[1]).add(prev[2]);
            prev[0]=prev[1];
            prev[1]=prev[2];
            prev[2] = nextValue;
            current++;
        }
        return prev[2];
    }


    public static void main(String[] args) {
        //plain recursion
        System.out.println("using recursion");
        for (int n=1;n<28;n++)
            System.out.println("n="+n+": "+ countSteps(n));


        System.out.println("using interative DP");
        for (int i=0;i<28;i++)
            System.out.println("n="+i+": "+ countStepsIterative(i));


        System.out.println("using recursion and cache (DP)");
        int maxN = 100;
        long[] map = new long[maxN];
        for (int i=0;i<maxN;i++)
            map[i]=-1;
        for (int i=0;i<maxN;i++)
            System.out.println("n="+i+": "+ countStepsDP(i, map));





        System.out.println("using recursion and cache (DP) and BigInteger");


        maxN = 20000;
        BigInteger[] mapBI = new BigInteger[maxN];
        for (int i=0;i<maxN;i++)
            mapBI[i]=BigInteger.valueOf(-1);
        for (int i=0;i<maxN;i++) {
            BigInteger result = countStepsDPBI(i, mapBI);
            String resultString;
            if (result.bitLength()>100*8)
                resultString = "("+(result.bitLength()+" digits number)");
            else
                resultString = result.toString();
            System.out.println("n="+i+": "+ resultString);
        }

        System.out.println("using iterative DP and BigInteger");
        System.out.println("20000: "+countStepsIterativeBI(20000));


    }
}
