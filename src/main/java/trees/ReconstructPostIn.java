package trees;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/7/13
 * Time: 11:29 AM
 * Reconstructs Binary Tree out of Post and In order traversals
 */
@SuppressWarnings("WeakerAccess")
public class ReconstructPostIn {


        private int[] postOrder;
        private int[] inOrder;

        public BinaryTree reconstruct(int[] postOrder, int[] inOrder) {
            if (postOrder.length!=inOrder.length)
                return null;
            this.postOrder = postOrder;
            this.inOrder = inOrder;

            return reconstruct(0, postOrder.length - 1, 0, inOrder.length - 1);
        }

        private BinaryTree reconstruct(int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart>preEnd)
                return null;

            if (preStart==preEnd)
                return new BinaryTree(postOrder[preEnd]);


            BinaryTree myNode = new BinaryTree(postOrder[preEnd]);

            @SuppressWarnings("UnusedAssignment") int vertexIndex = 0;
            for (vertexIndex=inEnd;vertexIndex>=inStart;vertexIndex--)
                if (postOrder[preEnd]==inOrder[vertexIndex])
                    break;


            int rightOffset = inEnd - vertexIndex;

            myNode.left = reconstruct(preStart, preEnd - rightOffset-1, inStart, inEnd - rightOffset - 1);
            myNode.right = reconstruct(preEnd - rightOffset, preEnd-1, inEnd-rightOffset+1, inEnd);

            return myNode;
        }


}
