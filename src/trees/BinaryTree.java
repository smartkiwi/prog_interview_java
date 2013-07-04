package trees;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTree {
    private Node root;

    class Node {
        int data;
        Node left;
        Node right;
        Node(int val) {
            data = val;
        }
    }

    BinaryTree()
    {
        root = null;
    }
}
