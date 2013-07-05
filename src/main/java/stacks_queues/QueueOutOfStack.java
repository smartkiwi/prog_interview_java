package stacks_queues;

import linked_list.LLStack;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:53 PM
 * Queue using Stack implementation
 */
@SuppressWarnings("WeakerAccess")
public class QueueOutOfStack {
    private final LLStack stack = new LLStack();
    public int getSize() {
        return stack.size;
    }

    public void add(Integer val) {
        stack.add(val);
    }

    public Integer get() {
        if (stack.size==0)
            return null;
        LLStack newStack = new LLStack();


        while(stack.size>1) {
            newStack.add(stack.get());
        }

        Integer returnValue = stack.get();

        while(newStack.size>0)
            stack.add(newStack.get());

        return returnValue;
    }


}
