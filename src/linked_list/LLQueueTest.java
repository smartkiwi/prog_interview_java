package linked_list;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:20 PM
 * Queue implementation using LinkedList test
 */
public class LLQueueTest extends TestCase {
    public void testQueue() throws Exception {
        LLQueue queue = new LLQueue();
        assertEquals(queue.size, 0);
        queue.add(0);
        assertEquals(queue.size, 1);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(queue.size,4);


        assertEquals(queue.get(), (Integer) 0);
        assertEquals(queue.size,3);
        assertEquals(queue.get(), (Integer) 1);
        assertEquals(queue.get(), (Integer) 2);
        assertEquals(queue.get(), (Integer) 3);

        /*
        ArrayList<Integer> outOfQueue = new ArrayList<Integer>();
        while(queue.size>0)
        {
            outOfQueue.add(queue.get());
        }

        Integer[] result = {0,1,2,3};


        assertEquals(outOfQueue, Utils.arrayToList(result));
        */

    }
    public void testQueue2() throws Exception {
        LLQueue queue = new LLQueue();
        assertEquals(queue.size, 0);
        for(int i=0;i<10;i++)
        {
            queue.add(i);
        }
        assertEquals(queue.size,10);

        ArrayList<Integer> outOfQueue = new ArrayList<Integer>();
        while(queue.size>0)
        {
            outOfQueue.add(queue.get());
        }

        Integer[] result = {0,1,2,3,4,5,6,7,8,9};
        assertEquals(outOfQueue, Utils.arrayToList(result));
    }
}
