package linked_list;


import junit.framework.TestCase;
import org.junit.Test;

import static linked_list.Utils.arrayToList;
import static linked_list.Utils.rotateNLeft;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 7:09 PM
 * Test for rotateNLeft method
 */
public class RotateNLeftTest extends TestCase {
    public void testRotateNLeft() throws Exception {
        LinkedListElement testList = Utils.createNewLinkedListWithNElements(5);

        LinkedListElement testResult = new LinkedListElement(3);
        testResult.next = new LinkedListElement(4);
        testResult.next.next = new LinkedListElement(0);
        testResult.next.next.next = new LinkedListElement(1);
        testResult.next.next.next.next = new LinkedListElement(2);

        System.out.println(testList.dump());
        System.out.println(testResult.dump());

        LinkedListElement result = rotateNLeft(testList, 3);
        assertEquals(testResult.dump(), result.dump());
    }


    public void testRotateNLeftException() throws Exception {
        LinkedListElement testList = Utils.createNewLinkedListWithNElements(5);
        //System.out.println(testList.dump());
        boolean thrown=false;
        try {
            LinkedListElement result = rotateNLeft(testList, 12);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    public void testRotateNLeft2() throws Exception {
        LinkedListElement testList = Utils.createNewLinkedListWithNElements(10);
        //System.out.println(testList.dump());
        LinkedListElement result = rotateNLeft(testList, 6);
        Integer[] expectedResult = {6,7,8,9,0,1,2,3,4,5};
        assertEquals(arrayToList(expectedResult), result.dump());
    }

    public void testRotateNLeft3() throws Exception {
        LinkedListElement testList = Utils.createNewLinkedListWithNElements(10);
        //System.out.println(testList.dump());
        LinkedListElement result = rotateNLeft(testList, 1);
        Integer[] expectedResult = {1,2,3,4,5,6,7,8,9,0};
        assertEquals(arrayToList(expectedResult), result.dump());
    }


}
