package stacks_queues;

import junit.framework.TestCase;
import linked_list.Utils;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:47 PM
 * Stack using Queue test case
 */
public class StackOutOfQueueTest extends TestCase {
    public void testAdd() throws Exception {
        StackOutOfQueue stack = new StackOutOfQueue();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        assertEquals(stack.getSize(),6);

        assertEquals(stack.get(), (Integer) 5);

        ArrayList<Integer> outOfStack = new ArrayList<Integer>();
        while(stack.getSize()>0)
        {
            outOfStack.add(stack.get());
        }

        Integer[] result = {4,3,2,1,0};

        assertEquals(outOfStack, Utils.arrayToList(result));

    }

}
