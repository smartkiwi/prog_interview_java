package linked_list;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 7:59 PM
 * Test case for the reverse LinkedList
 */
public class reverseLinkedListTest extends TestCase {
    public void testReverseLinkedList() throws Exception {
        LinkedListElement start = Utils.createNewLinkedListWithNElements(11);
        LinkedListElement reversed = Utils.reverseLinkedList(start);
        Integer[] result = {10,9,8,7,6,5,4,3,2,1,0};
        assertEquals(Utils.arrayToList(result), reversed.dump());
    }
}
