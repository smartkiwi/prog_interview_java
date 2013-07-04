package trees;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vvlad
 * Date: 7/4/13
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class BTVisitor implements BinaryTreeVisitor{
    ArrayList<Integer> result;

    BTVisitor(){
        result = new ArrayList<Integer>();
    }

    @Override
    public void visit(BinaryTree current, BinaryTree previous) {
        result.add(current.data);
    }

    public ArrayList<Integer> getResult() {
        return result;
    }
}
