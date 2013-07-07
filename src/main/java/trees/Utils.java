package trees;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 11:03 AM
 * Binary Trees utilities
 */
class Utils {

    public static BinaryTree buildTestTreeFull() {
        /*

           1
          / \
         2   5
        / \ / \
        3 4 6 7
         */
        BinaryTree myNode1 = new BinaryTree(1);
        myNode1.left = new BinaryTree(2);
        myNode1.left.left = new BinaryTree(3);
        myNode1.left.right = new BinaryTree(4);

        myNode1.right = new BinaryTree(5);

        myNode1.right.left = new BinaryTree(6);
        myNode1.right.right = new BinaryTree(7);
        return myNode1;
    }

    public static BinaryTree buildTestTreeRight() {
        /*
           1
         /   \
        2     3
         \     \
          4     5
              /  \
             6    7
            / \  / \
           8  9 10  11
         */
        BinaryTree myNode1 = new BinaryTree(1);
        myNode1.left = new BinaryTree(2);
        myNode1.right = new BinaryTree(3);
        myNode1.left.right = new BinaryTree(4);

        myNode1.right.right = new BinaryTree(5);

        myNode1.right.right.left = new BinaryTree(6);
        myNode1.right.right.right = new BinaryTree(7);

        myNode1.right.right.left.left = new BinaryTree(8);
        myNode1.right.right.left.right = new BinaryTree(9);

        myNode1.right.right.right.left = new BinaryTree(10);
        myNode1.right.right.right.right = new BinaryTree(11);
        return myNode1;
    }

    static int[] toIntArray(ArrayList<Integer> input) {
        int[] result = new int[input.size()];
        int i=0;
        for(Integer el : input) {
            result[i] = el;
            i++;
        }
        return result;
    }
}
