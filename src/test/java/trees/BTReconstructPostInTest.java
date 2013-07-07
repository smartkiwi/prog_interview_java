package trees;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/6/13
 * Time: 5:58 PM
 * Binary Tree reconstruct test cases
 */
public class BTReconstructPostInTest extends TestCase {
    public void testPreOrderInOrderReconstruct() throws Exception {
        BinaryTree myNode = Utils.buildTestTreeRight();
        ArrayList<Integer> postOrder = myNode.postOrderRecursive();

        System.out.println("PostOrderTraversal");
        System.out.println(postOrder);

        ArrayList<Integer> inOrder = myNode.inOrderRecursive();

        System.out.println("InOrderTraversal");
        System.out.println(inOrder);


        ReconstructPostIn worker = new ReconstructPostIn();
        BinaryTree myNodeNewNode = worker.reconstruct(Utils.toIntArray(postOrder), Utils.toIntArray(inOrder));
        assertEquals(postOrder, myNodeNewNode.postOrderRecursive());
        assertEquals(inOrder, myNodeNewNode.inOrderRecursive());


    }

    public void testPreOrderInOrderReconstruct2() throws Exception {
        BinaryTree myNode = new BinaryTree(1);
        myNode.left = new BinaryTree(2);
        myNode.right = new BinaryTree(4);
        myNode.left.left = new BinaryTree(3);


        myNode.right.left = new BinaryTree(5);
        myNode.right.left.left = new BinaryTree(6);
        myNode.right.left.right = new BinaryTree(7);
        myNode.right.left.right.right = new BinaryTree(8);

        ArrayList<Integer> postOrder = myNode.postOrderRecursive();

        System.out.println("PostOrderTraversal");
        System.out.println(postOrder);

        ArrayList<Integer> inOrder = myNode.inOrderRecursive();

        System.out.println("InOrderTraversal");
        System.out.println(inOrder);

        ReconstructPostIn worker = new ReconstructPostIn();
        BinaryTree myNodeNewNode = worker.reconstruct(Utils.toIntArray(postOrder), Utils.toIntArray(inOrder));
        assertEquals(postOrder, myNodeNewNode.postOrderRecursive());
        assertEquals(inOrder, myNodeNewNode.inOrderRecursive());

        BinaryTree myNodeNewNode2 = worker.reconstruct(Utils.toIntArray(postOrder), Utils.toIntArray(inOrder));
        assertEquals(postOrder, myNodeNewNode2.postOrderRecursive());
        assertEquals(inOrder, myNodeNewNode2.inOrderRecursive());


    }
}
