package trees;

import linked_list.*;

import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/6/13
 * Time: 8:55 PM
 * Reconstructs Binary Tree from preOrder and inOrder traversals
 */
public class ReconstructPreIn {
    //int preIndex;
    private int[] inOrderBackIndex;
    private int[] preOrder;
    private int[] inOrder;


    public BinaryTree reconstruct(int[] preOrder, int[] inOrder) {
        if (preOrder.length!=inOrder.length)
            return null;
        this.preOrder = preOrder;

        //preIndex = 0;

        int size = 0;
        //noinspection ForLoopReplaceableByForEach
        for(int i=0;i<inOrder.length;i++)
            if (inOrder[i]>size)
                size = inOrder[i];

        this.inOrderBackIndex = new int[size+1];

        for(int i=0;i<size+1;i++)
            this.inOrderBackIndex[i] = -1;

        for(int i=0;i<inOrder.length;i++) {
            if (this.inOrderBackIndex[inOrder[i]]>=0)
                throw new IllegalArgumentException("inOrder array should not contain duplicates: "+i+" "+this.inOrderBackIndex[inOrder[i]]+" "+inOrder[i]);
            this.inOrderBackIndex[inOrder[i]] = i;
        }

        return reconstruct(0, preOrder.length-1, 0);
    }

    private BinaryTree reconstruct(int preStart, int preEnd, int inStart) {
        if (preStart>preEnd)
            return null;

        if (preStart==preEnd)
            return new BinaryTree(preOrder[preStart]);


        BinaryTree myNode = new BinaryTree(preOrder[preStart]);

        int vertexIndex = inOrderBackIndex[preOrder[preStart]];
        if (vertexIndex<inStart || vertexIndex<0)
            vertexIndex=0;


        int leftOffset = vertexIndex - inStart;

        myNode.left = reconstruct(preStart+1, preStart+leftOffset, inStart);
        myNode.right = reconstruct(preStart+leftOffset+1, preEnd, inStart+leftOffset+1);

        return myNode;
    }


    public BinaryTree reconstructNoLookupTable(int[] preOrder, int[] inOrder) {
        if (preOrder.length!=inOrder.length)
            return null;
        this.preOrder = preOrder;
        this.inOrder = inOrder;

        return reconstructNoLookupTable(0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private BinaryTree reconstructNoLookupTable(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart>preEnd)
            return null;

        if (preStart==preEnd)
            return new BinaryTree(preOrder[preStart]);


        BinaryTree myNode = new BinaryTree(preOrder[preStart]);

        @SuppressWarnings("UnusedAssignment") int vertexIndex = 0;
        for (vertexIndex=inStart;vertexIndex<=inEnd;vertexIndex++)
            if (preOrder[preStart]==inOrder[vertexIndex])
                break;


        int leftOffset = vertexIndex - inStart;

        myNode.left = reconstructNoLookupTable(preStart + 1, preStart + leftOffset, inStart, inStart + leftOffset - 1);
        myNode.right = reconstructNoLookupTable(preStart + leftOffset + 1, preEnd, inStart + leftOffset + 1, inEnd);

        return myNode;
    }

}
