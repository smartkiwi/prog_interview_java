package linked_list;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 9:17 PM
 * Queue implementation using LinkedList
 */
public class LLQueue {
    private LinkedListElement first;
    private LinkedListElement last;
    public int size;
    public void add(Integer val) {
        LinkedListElement newElement = new LinkedListElement(val);
        if (first==null) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            last = newElement;
        }
        size++;
    }

    public Integer get() {
        if (first==null)
            return null;
        Integer retValue = first.value;
        first = first.next;
        size--;
        return retValue;
    }
}
