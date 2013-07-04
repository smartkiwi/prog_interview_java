package trees;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 11:14 AM
 * Binary Tree traversal tests
 */
public class BinaryTreeTest extends TestCase {
    public void testPreOrderRecursive() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> order = myNode.preOrderRecursive();

        System.out.println("PreOrderTraversal");
        System.out.println(order);

        Integer[] expectedResultIntAr = {1,2,3,4,5,6,7};
        assertEquals(order, linked_list.Utils.arrayToList(expectedResultIntAr));
    }
    public void testInOrderRecursive() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> order = myNode.inOrderRecursive();

        System.out.println("InOrderTraversal");
        System.out.println(order);

        Integer[] expectedResultIntAr = {3,2,4,1,6,5,7};
        assertEquals(order, linked_list.Utils.arrayToList(expectedResultIntAr));
    }


    public void testPostOrderRecursive() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> order = myNode.postOrderRecursive();

        System.out.println("PostOrderTraversal");
        System.out.println(order);

        Integer[] expectedResultIntAr = {3,4,2,6,7,5,1};
        assertEquals(order, linked_list.Utils.arrayToList(expectedResultIntAr));
    }

    public void testBSFTraversal() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> order = myNode.BFSTraversal();

        System.out.println("BFSTraversal");
        System.out.println(order);

        Integer[] expectedResultIntAr = {1,2,5,3,4,6,7};
        assertEquals(order, linked_list.Utils.arrayToList(expectedResultIntAr));
    }


    public void testPostOrderNonRecursiveTraversal() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> orderRecursive = myNode.postOrderRecursive();
        ArrayList<Integer> orderNonRecursive = myNode.postOrderNonRecursive();

        assertEquals(orderNonRecursive, orderRecursive);
    }



    public void testInOrderNonRecursiveTraversal() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> orderRecursive = myNode.inOrderRecursive();
        ArrayList<Integer> orderNonRecursive = myNode.inOrderNonRecursive();

        assertEquals(orderNonRecursive, orderRecursive);
    }



    public void testPreOrderNonRecursiveTraversal() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeFull();
        ArrayList<Integer> orderRecursive = myNode.preOrderRecursive();
        ArrayList<Integer> orderNonRecursive = myNode.preOrderNonRecursive();

        assertEquals(orderNonRecursive, orderRecursive);
    }


}
