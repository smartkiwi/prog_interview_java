package trees;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 3:02 PM
 * Interface used to visit every BinaryTree node
 */
public interface BinaryTreeVisitor {
    public void visit(BinaryTree current, BinaryTree previous);
}
