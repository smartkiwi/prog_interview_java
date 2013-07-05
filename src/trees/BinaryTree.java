package trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 11:02 AM
 * Binary tree node class
 */
public class BinaryTree {
    @SuppressWarnings("WeakerAccess")
    final
    int data;
    BinaryTree left;
    BinaryTree right;


    private ArrayList<Integer> result;

    private enum TraversalType {
        PREORDER, INORDER, POSTORDER
    }

    public BinaryTree(int val) {
        data = val;
    }

    public ArrayList<Integer> preOrderRecursive()
    {
        this.result = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.PREORDER);
        return this.result;
    }
    public ArrayList<Integer> inOrderRecursive()
    {
        this.result = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.INORDER);
        return this.result;
    }

    public ArrayList<Integer> postOrderRecursive()
    {
        this.result = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.POSTORDER);
        return this.result;
    }


    private void DFSTraversalUniversal(BinaryTree myNode, TraversalType traversalType) {
        if (myNode==null)
            myNode = this;
        if (traversalType==TraversalType.PREORDER)
            this.result.add(myNode.data);
        if (myNode.left!=null)
            DFSTraversalUniversal(myNode.left, traversalType);
        if (traversalType==TraversalType.INORDER)
            this.result.add(myNode.data);
        if (myNode.right!=null)
            DFSTraversalUniversal(myNode.right, traversalType);
        if (traversalType==TraversalType.POSTORDER)
            this.result.add(myNode.data);
    }

    public ArrayList<Integer> BFSTraversal() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(this);
        while(!queue.isEmpty()) {
            BinaryTree node = queue.remove();
            result.add(node.data);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return result;
    }

    private ArrayList<Integer> traverseNonRecursive(TraversalType traversalType) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<BinaryTree> stack = new LinkedList<BinaryTree>();
        stack.push(this);
        BinaryTree previous = null;

        while(!stack.isEmpty())
        {
            BinaryTree current = stack.peek();
            if (current==null)
                stack.pop();
            else if (current.left==null && current.right==null)
            {
                //Case 1
                //at leaf node
                //always - visit leaf
                result.add(current.data);
                stack.pop();
            }
            else if (previous == current.right)
            {
                //Case 2
                //returned up after right node
                if (traversalType==TraversalType.POSTORDER)
                    result.add(current.data);
                stack.pop();
            }
            else if (previous == current.left)
            {
                //Case 3
                //returned up from the left node
                if (traversalType==TraversalType.INORDER)
                    result.add(current.data);
                stack.push(current.right);
            }
            else {
                //Case 4
                //everything else - let's go to the left node down
                if (traversalType==TraversalType.PREORDER)
                    result.add(current.data);
                stack.push(current.left);
            }
            previous = current;
        }

        return result;
    }


    public ArrayList<Integer> postOrderNonRecursive() {
        return traverseNonRecursive(TraversalType.POSTORDER);
    }

    public ArrayList<Integer> inOrderNonRecursive() {
        return traverseNonRecursive(TraversalType.INORDER);
    }

    public ArrayList<Integer> preOrderNonRecursive() {
        return traverseNonRecursive(TraversalType.PREORDER);
    }

    public boolean isValidBST() {
        return isValidBSTNode(this);
    }

    private boolean isValidBSTNode(BinaryTree current) {
        if (current.left!=null && (current.data<current.left.data || isValidBSTNode(current.left)))
            return false;

        if (current.right!=null && (current.data>current.right.data || isValidBSTNode(current.right)))
            return false;
        return true;
    }

}
