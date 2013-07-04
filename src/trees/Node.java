package trees;

import linked_list.LLQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 11:02 AM
 * Binary tree node class
 */
public class Node {
    @SuppressWarnings("WeakerAccess")
    final
    int data;
    Node left;
    Node right;

    private ArrayList<Integer> preOrderList;

    private enum TraversalType {
        PREORDER, INORDER, POSTORDER
    }

    public Node(int val) {
        data = val;
    }

    public ArrayList<Integer> preOrderRecursive()
    {
        this.preOrderList = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.PREORDER);
        return this.preOrderList;
    }
    public ArrayList<Integer> inOrderRecursive()
    {
        this.preOrderList = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.INORDER);
        return this.preOrderList;
    }

    public ArrayList<Integer> postOrderRecursive()
    {
        this.preOrderList = new ArrayList<Integer>();
        DFSTraversalUniversal(null, TraversalType.POSTORDER);
        return this.preOrderList;
    }


    private void DFSTraversalUniversal(Node myNode, TraversalType traversalType) {
        if (myNode==null)
            myNode = this;
        if (traversalType==TraversalType.PREORDER)
            this.preOrderList.add(myNode.data);
        if (myNode.left!=null)
            DFSTraversalUniversal(myNode.left, traversalType);
        if (traversalType==TraversalType.INORDER)
            this.preOrderList.add(myNode.data);
        if (myNode.right!=null)
            DFSTraversalUniversal(myNode.right, traversalType);
        if (traversalType==TraversalType.POSTORDER)
            this.preOrderList.add(myNode.data);
    }

    public ArrayList<Integer> BFSTraversal() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(this);
        while(!queue.isEmpty()) {
            Node node = queue.pop();
            result.add(node.data);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        return result;
    }
}
