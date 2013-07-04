package linked_list;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:06 PM
 * Stack implementation using LinkedList
 */
public class LLStack {
    private LinkedListElement current;
    public int size;
    public void add(Integer val) {
        LinkedListElement newElement = new LinkedListElement(val);
        if (current!=null)
            newElement.next = current;
        current = newElement;
        size++;
    }

    public Integer get() {
        if (current==null)
            return null;
        Integer returnValue = current.value;
        current = current.next;
        size--;
        return returnValue;
    }
}
