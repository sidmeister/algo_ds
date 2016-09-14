package tree;
import stack_queue.*;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class AlgebraicExpression {

    public static void main(String[] args) {
        String postfix = "235+*";
        Stack<Node> Stx = new Stack(10);
        //BinaryTree binaryTree = new BinaryTree();
        for(int i=0; i<postfix.length();i++)
        {
            char c = postfix.charAt(i);
            if("*".equals(c) || "+".equals(c)) {
                Node tNode = new Node(c);
                Node right = Stx.pop();
                Node left = Stx.pop();
                tNode.rightChild = right;
                tNode.leftChild = left;
                Stx.push(tNode);
            }
            else
            {
                Node tNode = new Node(c);
                Stx.push(tNode);

            }
        }


    }
}
