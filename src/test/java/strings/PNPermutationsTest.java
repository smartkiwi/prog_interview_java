package strings;

import junit.framework.TestCase;

import java.util.ArrayList;

import static strings.PNPermutations.generate;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/2/13
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PNPermutationsTest extends TestCase {
    public void testGenerate1() throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        char comb[] = {'a','b','c'};
        result.add("");
        ArrayList<String> validResult = new ArrayList<String>();
        validResult.add("a");
        validResult.add("b");
        validResult.add("c");
        ArrayList<String> newResult = generate(result, comb);
        assertEquals(newResult.size(), 3);
        assertEquals(newResult, validResult);
    }

    public void testGenerate2() throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        char comb[] = {'c','d'};
        result.add("a");
        result.add("b");
        ArrayList<String> validResult = new ArrayList<String>();
        validResult.add("ac");
        validResult.add("ad");
        validResult.add("bc");
        validResult.add("bd");
        ArrayList<String> newResult = generate(result, comb);
        assertEquals(newResult.size(), 4);
        assertEquals(newResult, validResult);
    }
}
