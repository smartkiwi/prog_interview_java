package linked_list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 7:54 PM
 * Utils for working with LinkedList:
 *  converting array to ArrayList
 *  reversing LinkedList
 */
public class Utils {
    // for Java 1.5+
    public static <T> ArrayList<T> arrayToList(final T[] array) {
        final ArrayList<T> l = new ArrayList<T>(array.length);

        Collections.addAll(l, array);
        return (l);
    }

    public static ArrayList<Integer> arrayToList(final int[] array) {
        final ArrayList<Integer> l = new ArrayList<Integer>(array.length);

        for (int el: array)
            l.add(el);
        return (l);
    }


    public static LinkedListElement reverseLinkedList(LinkedListElement first) {
        if (first==null)
            return null;
        LinkedListElement reversed = null;
        while(first!=null){
            LinkedListElement nextElement = first.next;
            first.next = null;
            if (reversed!=null) {
                first.next = reversed;
            }
            reversed = first;
            first = nextElement;
        }
        return reversed;
    }

    public static LinkedListElement createNewLinkedListWithNElements(int maxElements) {
        LinkedListElement lastElement = null;
        LinkedListElement start = null;
        for(int i=0;i< maxElements;i++){
            if (lastElement==null) {
                lastElement = new LinkedListElement(i);
                start = lastElement;
            } else {
                lastElement.next = new LinkedListElement(i);
                lastElement = lastElement.next;
            }
        }
        return start;
    }

    public static LinkedListElement rotateNLeft(LinkedListElement current, int n) throws IllegalArgumentException {
        if (n==0)
            return current;
        LinkedListElement newTail = current;
        while(n>1 && newTail.next!=null) {
            newTail = newTail.next;
            n--;
        }
        if (n>1)
            throw new IllegalArgumentException("N should be less than size of linked list: "+n);

        LinkedListElement newHead = newTail.next;
        newTail.next = null;

        LinkedListElement newNewTail = newHead;

        assert newNewTail != null;
        while (newNewTail.next!=null)
            newNewTail = newNewTail.next;

        newNewTail.next = current;
        current = newHead;
        return current;
    }


}
