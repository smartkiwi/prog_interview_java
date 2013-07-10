package strings;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/2/13
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class PNPermutations {
    static char[][] combinations = {
            /* 0 */{' '},
            /* 1 */{' '},
            /* 2 */{'a','b','c'},
            /* 3 */{'d','e','f'},
            /* 4 */{'g','h','i'},
            /* 5 */{'j','k','l'},
            /* 6 */{'m','n','o'},
            /* 7 */{'p','q','r','s'},
            /* 8 */{'t','u','v'},
            /* 9 */{'w','x','y','z'}
    };

    public static ArrayList<String> generate(ArrayList<String> input, char[] combination) throws IllegalArgumentException {
        if (input.size()==0)
            throw new IllegalArgumentException("Input should contain at least one element");
        ArrayList<String> result = new ArrayList<String>();
        for (String line: input)
            for (char symbol: combination)
                result.add(line+symbol);
        return result;
    }

    public static ArrayList<String> permutate(int[] input) throws IllegalArgumentException {
        if (!isValidPhoneNumbers(input))
            throw new IllegalArgumentException("Input should consist of positive single digit numbers only");
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        for (int digit: input)
            result = generate(result, combinations[digit]);
        return result;
    }
    private static boolean isValidPhoneNumbers(int[] input) {
        for (int digit: input)
            if (digit<0 || digit>9)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] input = {8,5,2,3, 9};
        try {
            ArrayList<String> result = permutate(input);
            System.out.println("generated "+result.size()+" combinations");
            for (String word: result)
                System.out.println("\t'"+word+"'");
        }
        catch (IllegalArgumentException e) {
            System.err.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

}
