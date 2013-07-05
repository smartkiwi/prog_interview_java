package linked_list;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 6/29/13
 * Time: 4:51 PM
 * LinkedList Element implementation
 */
public class LinkedListElement{
    public final Integer value;
    public LinkedListElement next;

    LinkedListElement(Integer value){
        this.value = value;
    }
    public boolean hasNext()
    {
        return next!=null;
    }
// --Commented out by Inspection START (7/4/13 10:38 AM):
// --Commented out by Inspection START (7/4/13 10:38 AM):
// --Commented out by Inspection START (7/4/13 10:39 AM):
//////    public LinkedListElement addBefore(LinkedListElement newEl){
//////        newEl.next = this;
//////        return newEl;
//////    }
////// --Commented out by Inspection STOP (7/4/13 10:38 AM)
////    public void deleteAfter() {
////        if (this.next!=null)
////            this.next = next.next;
////    }
//// --Commented out by Inspection STOP (7/4/13 10:38 AM)
//    public void insertAfter(LinkedListElement newEl) {
//        if (this.next==null)
//            this.next = newEl;
//        else {
//            LinkedListElement temp = this.next;
//            this.next = newEl;
//            newEl.next = temp;
//        }
//    }
// --Commented out by Inspection STOP (7/4/13 10:39 AM)

    public ArrayList<Integer> dump() {
        ArrayList<Integer> d = new ArrayList<Integer>();
        LinkedListElement current = this;
        while(current!=null) {
            d.add(current.value);
            current = current.next;
        }
        return d;
    }

// --Commented out by Inspection START (7/4/13 10:39 AM):
//    public void prIntegerLinkedList() {
//        System.out.println(dump().toString());
//    }
// --Commented out by Inspection STOP (7/4/13 10:39 AM)

}
