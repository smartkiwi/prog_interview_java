package linked_list;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:10 PM
 * Stack implementation using LinkedList example
 */
public class LLStackTest extends TestCase {
    public void testStack() throws Exception {
        LLStack stack = new LLStack();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);

        assertEquals(stack.size,4);

        ArrayList<Integer> outOfStack = new ArrayList<Integer>();
        while(stack.size>0)
        {
            outOfStack.add(stack.get());
        }

        Integer[] result = {3,2,1,0};

        assertEquals(outOfStack, Utils.arrayToList(result));
    }

    public void testStack2() throws Exception {
        LLStack stack = new LLStack();
        assertEquals(stack.size,0);

        stack.add(0);
        stack.add(1);
        assertEquals(stack.get(), (Integer) 1);
        stack.add(2);
        stack.add(3);

        assertEquals(stack.size,3);

        ArrayList<Integer> outOfStack = new ArrayList<Integer>();
        while(stack.size>0)
        {
            outOfStack.add(stack.get());
        }

        Integer[] result = {3,2,0};

        assertEquals(outOfStack, Utils.arrayToList(result));
    }

}
