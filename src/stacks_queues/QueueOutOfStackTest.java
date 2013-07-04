package stacks_queues;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:56 PM
 * Queue using Stack Test cases
 */
public class QueueOutOfStackTest extends TestCase {
    public void testGet() throws Exception {
        QueueOutOfStack queue = new QueueOutOfStack();
        assertEquals(queue.getSize(),0);
        queue.add(0);
        queue.add(1);
        queue.add(2);
        assertEquals(queue.getSize(),3);
        queue.add(3);
        queue.add(4);
        assertEquals(queue.get(), (Integer) 0);
        assertEquals(queue.getSize(),4);
        assertEquals(queue.get(), (Integer) 1);
        assertEquals(queue.get(), (Integer) 2);
        assertEquals(queue.get(), (Integer) 3);
        assertEquals(queue.get(), (Integer) 4);
    }
}
