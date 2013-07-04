package stacks_queues;

import linked_list.LLQueue;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:39 PM
 * Stack using Queue implementation
 */
@SuppressWarnings("WeakerAccess")
public class StackOutOfQueue {
    private LLQueue queue = new LLQueue();
    public int getSize() {
        return queue.size;
    }
    public void add(Integer val) {
        queue.add(val);
    }
    public Integer get() {
        if (queue.size==0)
            return null;

        LLQueue newQueue = new LLQueue();
        while(queue.size>1) {
            newQueue.add(queue.get());
        }
        Integer returnValue = queue.get();
        queue = newQueue;
        return returnValue;
    }
}
