package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/14/13
 * Time: 3:09 PM
 * print all possible ways to give change using 25,10,5,1 coins
 */
public class PrintChangeCombinations {

    public static int ways(int n, int denom, int c25, int c10, int c5) {
        int nextDenom = 0;
        if (denom==25)
            nextDenom=10;
        if (denom==10)
            nextDenom=5;
        if (denom==5)
            nextDenom=1;
        if (denom==1) {
            System.out.println(c25 + "*25, " + c10 + "*10," + c5 + "*5, " + n + "*1");
            return 1;
        }

        int result = 0;
        int coins = 0;
        while(coins*denom<=n) {
            if (denom==25)
                c25=coins;
            if (denom==10)
                c10=coins;
            if (denom==5)
                c5=coins;
            result+=ways(n - coins * denom, nextDenom, c25, c10, c5);
            coins++;
        }
        return result;

    }

    private static void printCombination(int[] combination) {

    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("n="+ n +" "+ways(n, 25, 0,0,0));
    }



}
