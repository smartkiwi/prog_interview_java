package trees;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 11:03 AM
 * Binary Trees utilities
 */
class Utils {

    public static Node buildTestTreeFull() {
        Node myNode1 = new Node(1);
        myNode1.left = new Node(2);
        myNode1.left.left = new Node(3);
        myNode1.left.right = new Node(4);

        myNode1.right = new Node(5);

        myNode1.right.left = new Node(6);
        myNode1.right.right = new Node(7);
        return myNode1;
    }

    public static Node buildTestTreeRight() {
        Node myNode1 = new Node(1);
        myNode1.left = new Node(2);
        myNode1.right = new Node(3);
        myNode1.left.right = new Node(4);

        myNode1.right.right = new Node(5);

        myNode1.right.right.left = new Node(6);
        myNode1.right.right.right = new Node(7);

        myNode1.right.right.left.left = new Node(8);
        myNode1.right.right.left.right = new Node(9);

        myNode1.right.right.right.left = new Node(10);
        myNode1.right.right.right.right = new Node(11);
        return myNode1;
    }

}
