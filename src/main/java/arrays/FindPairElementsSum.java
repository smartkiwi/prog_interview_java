package arrays;

import linked_list.Utils;

import java.util.ArrayList;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/9/13
 * Time: 9:50 AM
 * Find pair of elements in array with sum = X
 */
public class FindPairElementsSum {

    public static ArrayList<Integer> findPairElementsSum(int[] input, int x) {
        //this method version is built assuming there are no duplicate pairs in the array
        //we assume there are 256 distinct numbers in the array 0-256

        //prepare indexed lookup table
        int[] indexed = new int[256];

        int emptyValue = -1;
        Arrays.fill(indexed, emptyValue);

        int even_count=0;
        if (x%2==0){

        }

        for (int i=0; i<input.length; i++) {
            if (input[i]<0 || input[i]>255)
                throw new IllegalArgumentException("values in array should be between 0 and 255 :"+input[i]);
            if (input[i]<=x) {
                int b = x - input[i];
                indexed[b] = i;
                if (x%2==0 && input[i]*2==x)
                    even_count++;
            }
        }

        System.out.println(Utils.arrayToList(indexed));

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int b=0; b<input.length; b++) {
            int posOfA = indexed[b];
            if (posOfA>=0 && posOfA<256) {
                int a = input[posOfA];

                boolean toAdd = false;

                if (x%2==0 && a*2==x) {
                    if (even_count>1)
                    {
                        even_count=even_count-2;
                        toAdd=true;
                    }
                }
                else {
                    toAdd=true;
                }

                if (toAdd) {
                    System.out.println(a+" + "+b+" = "+x);
                    indexed[x-b] = emptyValue;
                    result.add(a);
                    result.add(b);
                }
            }
        }

        return result;
    }

    public static void printResults(int x, ArrayList<Integer> result) {
        System.out.println("Results");
        for(int i=0;i<result.size();i++) {
            int a = result.get(i);
            int b = result.get(++i);
            System.out.println(a+" + "+b+" = "+x);
        }
    }

    public static void main(String[] args) {
        int[] input = {16,15,14,13,12,11,10,0,9,8,7,6,5,4,3,2,1};
        printResults(12, findPairElementsSum(input, 12));

        int[] input1 = {16,16,15,15,14,14,13,13,12,12,11,11,10,10,0,0,9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1};
        printResults(12, findPairElementsSum(input1, 12));

    }
}
