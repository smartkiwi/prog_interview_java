package linked_list;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 5:11 PM
 * LinkedList methods test
 */
public class LinkedListElementTest extends TestCase {


    public void testHasNext() throws Exception {
        LinkedListElement el = new LinkedListElement(1);
        assertFalse(el.hasNext());
        el.next = new LinkedListElement(2);
        assertTrue(el.hasNext());
    }

    public void testAddBefore() throws Exception {
        LinkedListElement el = new LinkedListElement(1);
        LinkedListElement el2 = new LinkedListElement(2);
        el2.next = el;
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(2);
        testArray.add(1);
        //el2.printLinkedList();
        assertEquals(el2.dump(), testArray);
    }

    public void testInsertAfterDirect() throws Exception {
        LinkedListElement el = new LinkedListElement(1);
        el.next = new LinkedListElement(2);
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(1);
        testArray.add(2);
        assertEquals(el.dump(), testArray);
    }

    public void testInsertAfter() throws Exception {

        LinkedListElement start = null;
        LinkedListElement last = null;
        for (int i=0;i<10;i++)
        {
            LinkedListElement newEl = new LinkedListElement(i);
            if (start==null) {
                start = newEl;
                last = newEl;
            } else {
                last.next = newEl;
                last = newEl;
            }

        }

        Integer[] testResult = {0,1,2,3,4,5,6,7,8,9};
        assert start != null;
        assertEquals(Utils.arrayToList(testResult), start.dump());

    }

    public void testDump() throws Exception {
        LinkedListElement start = Utils.createNewLinkedListWithNElements(10);
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        for (int i=0;i<10;i++) {
            testArray.add(i);
        }
        assertEquals(testArray, start.dump());
        //start.printLinkedList();
    }

}
