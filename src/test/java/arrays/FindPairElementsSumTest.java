package arrays;

import junit.framework.TestCase;

import java.util.ArrayList;

import static arrays.FindPairElementsSum.printResults;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/9/13
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindPairElementsSumTest extends TestCase {
    public void testFindPairElementsSum() throws Exception {
        int[] input = {4,3,5,0,6,1};
        int x = 7;
        ArrayList<Integer> result = FindPairElementsSum.findPairElementsSum(input, x);
        printResults(x,result);

        ArrayList<String> pairs = prepareCheckResult(result);
        assertEquals(pairs.size(),3);
        assertTrue(pairs.indexOf("[6+1]")>=0);
        assertTrue(pairs.indexOf("[5+2]")>=0);
        assertTrue(pairs.indexOf("[4+3]")>=0);

    }

    public void testFindPairElementsSumEvenCase1() throws Exception {
        //X is odd and there is only one X/2 value in the array
        int[] input = {4,3,5,0,6,2};
        int x = 8;
        ArrayList<Integer> result = FindPairElementsSum.findPairElementsSum(input, x);
        printResults(x,result);

        ArrayList<String> pairs = prepareCheckResult(result);
        assertEquals(2,pairs.size());
        assertTrue(pairs.indexOf("[6+2]")>=0);
        assertTrue(pairs.indexOf("[5+3]")>=0);
    }

    public void testFindPairElementsSumEvenCase2() throws Exception {
        //X is odd and there are two X/2 values in the array
        int[] input = {4,3,5,0,6,2,4};
        int x = 8;
        ArrayList<Integer> result = FindPairElementsSum.findPairElementsSum(input, x);
        printResults(x,result);

        ArrayList<String> pairs = prepareCheckResult(result);
        assertEquals(3,pairs.size());
        assertTrue(pairs.indexOf("[6+2]")>=0);
        assertTrue(pairs.indexOf("[5+3]")>=0);
        assertTrue(pairs.indexOf("[4+4]")>=0);
    }

    public void _testFindPairElementsSumEvenCase3() throws Exception {
        //X is odd and there are five X/2 values in the array
        int[] input = {4,3,5,0,6,2,4,4,4,4};
        int x = 8;
        ArrayList<Integer> result = FindPairElementsSum.findPairElementsSum(input, x);
        printResults(x,result);

        ArrayList<String> pairs = prepareCheckResult(result);
        assertEquals(4,pairs.size());
        assertTrue(pairs.indexOf("[6+2]")>=0);
        assertTrue(pairs.indexOf("[5+3]")>=0);
        assertTrue(pairs.indexOf("[4+4]")>=0);
        assertTrue(pairs.indexOf("[8+0]")<0);
    }



    private ArrayList<String> prepareCheckResult(ArrayList<Integer> result) {
        ArrayList<String> checkResult = new ArrayList<String>();
        for(int i=0;i<result.size();i++) {
            int a = result.get(i);
            int b = result.get(++i);
            if (a>b)
                checkResult.add("["+a+'+'+b+']');
            else
                checkResult.add("["+b+'+'+a+']');
        }
        return checkResult;
    }
}
