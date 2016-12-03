package tree;
import stack_queue.Stack;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class AlgebraicExpression {

    public static void main(String[] args) {
        String postfix = "235+*";
        Stack<TNode> Stx = new Stack(10);
        //BinaryTree binaryTree = new BinaryTree();
        for(int i=0; i<postfix.length();i++)
        {
            char c = postfix.charAt(i);
            if("*".equals(c) || "+".equals(c)) {
                TNode tNode = new TNode(c);
                TNode right = Stx.pop();
                TNode left = Stx.pop();
                tNode.leftChild = right;
                tNode.rightChild = left;
                Stx.push(tNode);
            }
            else
            {
                TNode tNode = new TNode(c);
                Stx.push(tNode);

            }
        }


    }
}
