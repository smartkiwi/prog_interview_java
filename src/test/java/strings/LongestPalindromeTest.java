package strings;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/8/13
 * Time: 4:18 PM
 * Test longest palindrome finder
 */
public class LongestPalindromeTest extends TestCase {
    public void testFindLongestPalindrome() throws Exception {
        LongestPalindrome finder = new LongestPalindrome("haaeadodbhllerebbbb");
        assertEquals("bbbb",finder.findLongestPalindrome());

        LongestPalindrome finder1 = new LongestPalindrome("haaeadodbhllerebbbbccccccaa");
        assertEquals("cccccc",finder1.findLongestPalindrome());

        LongestPalindrome finder2 = new LongestPalindrome("");
        assertEquals(null,finder2.findLongestPalindrome());

        LongestPalindrome finder3 = new LongestPalindrome("a");
        assertEquals(null,finder3.findLongestPalindrome());

        LongestPalindrome finder4 = new LongestPalindrome("aa");
        assertEquals("aa",finder4.findLongestPalindrome());

    }

    public void testFindPalindromAtPosition() throws Exception {


        LongestPalindrome finder = new LongestPalindrome("haaeadodbhllerebbbb");
        LongestPalindrome.Palindrome result = finder.findPalindromeAtPosition(5,7);
        assertEquals(5,result.start);
        assertEquals(3,result.length);

        LongestPalindrome.Palindrome result2 = finder.findPalindromeAtPosition(1,2);
        assertEquals(1,result2.start);
        assertEquals(2,result2.length);

        LongestPalindrome.Palindrome result3 = finder.findPalindromeAtPosition(16,17);
        assertEquals(15,result3.start);
        assertEquals(4,result3.length);

        LongestPalindrome.Palindrome result1 = finder.findPalindromeAtPosition(1,7);
        assertEquals(result1, null);

    }
}

