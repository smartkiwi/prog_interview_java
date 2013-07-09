package strings;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/8/13
 * Time: 1:48 PM
 * Finds the longest palindrome in the string. In case when there are multiple longest palindromes in a string - returns the last found
 * palindrome could consist of any char
 */
public class LongestPalindrome {

    class Palindrome {
        final int start;
        int length;
        Palindrome(int start, int length){
            this.start = start;
            this.length = length;
        }
    }

    private final char[] charsArray;
    private Palindrome longestPalindrome;

    LongestPalindrome(String input) {
        this.charsArray = Utils.convertStringToCharArray(input);
    }


    public String findLongestPalindrome() {
        for (int i=0; i<charsArray.length;i++) {
            if (!setLongestPalindrome(findPalindromeAtPosition(i-1, i)))
                setLongestPalindrome(findPalindromeAtPosition(i-1,i+1));
        }
        return getLongestPalindrome();
    }

    private String getLongestPalindrome() {
        if (longestPalindrome!=null) {
            return new StringBuilder().append(charsArray,longestPalindrome.start,longestPalindrome.length).toString();
        }
        return null;
    }


    private boolean setLongestPalindrome(Palindrome found) {
        if (found!=null && (longestPalindrome==null || longestPalindrome.length<found.length)){
            longestPalindrome = found;
            return true;
        }
        return false;
    }

    public Palindrome findPalindromeAtPosition(int right, int left) {
        boolean found = false;
        while(right>=0 && left<charsArray.length && charsArray[right]==charsArray[left]) {
            found = true;
            right--;
            left++;
        }
        if (!found)
            return null;
        right++;
        left--;
        return new Palindrome(right, left-right+1);
    }

}
