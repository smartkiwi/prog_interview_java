package recursion;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/14/13
 * Time: 2:54 PM
 * Count the number of ways to give change for amount of N  using 25,10,5,1 coins
 */
public class CountCoins {



    public static int ways(int n, int denom) {
        int nextDenom = 0;
        if (denom==25)
            nextDenom=10;
        if (denom==10)
            nextDenom=5;
        if (denom==5)
            nextDenom=1;
        if (denom==1)
            return 1;

        int result = 0;
        int coins = 0;
        while(coins*denom<=n) {
            result+=ways(n - coins * denom, nextDenom);
            coins++;
        }
        return result;

    }

    public static void main(String[] args) {
        for(int i=1;i<127;i++)
            System.out.println("n="+i+" "+ways(i, 25));
    }

}
