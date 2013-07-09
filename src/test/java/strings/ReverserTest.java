package strings;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/8/13
 * Time: 11:25 AM
 * Tests for reversing string
 */
public class ReverserTest extends TestCase {
    public void testReverseWords() throws Exception {
        String testString = "test string many words";
        char [] charArray = Utils.convertStringToCharArray(testString);
        Reverser.reverseWordsOrder(charArray);

        String testResult = "words many string test";
        assertEquals(Utils.convertCharArrayToString(charArray),testResult);


        char[] oneWord = Utils.convertStringToCharArray("oneword");
        Reverser.reverseWordsOrder(oneWord);
        assertEquals("oneword", Utils.convertCharArrayToString(oneWord));


    }

    public void testReversePartOfString_full() throws Exception {
        String testString = "test string many words";
        char [] charArray = Utils.convertStringToCharArray(testString);
        Reverser.reversePartOfCharArray(charArray, 0, charArray.length - 1);
        String testResult = new StringBuilder(testString).reverse().toString();
        assertEquals(Utils.convertCharArrayToString(charArray),testResult);
    }

    public void testReversePartOfString_part() throws Exception {
        String testString = "test string many words";
        char [] charArray = Utils.convertStringToCharArray(testString);
        Reverser.reversePartOfCharArray(charArray, 0, 3);

        assertEquals(Utils.convertCharArrayToString(charArray),"tset string many words");

        Reverser.reversePartOfCharArray(charArray, 5, 10);

        assertEquals(Utils.convertCharArrayToString(charArray),"tset gnirts many words");


    }

}

