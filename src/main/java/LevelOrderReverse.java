import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by srathi on 11/25/16.
 *  /*
 in level order traversal, we visit the nodes level by level from left to right.
 You only have to complete the function.
 For example:

     1
  /      \
 2        3
 / \    /  \
 4   5  6  7

 For the above tree, the output should  is  4 5 6 7 2 3 1

 */


public class LevelOrderReverse {

    public static void levelOrderReverse(Node root)
    {
        if (root == null)
            return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        Stack<Node> stack = new Stack<>();
        while (!list.isEmpty())
        {
            root = list.pop();
            if (root.rightChild != null)
                list.add(root.rightChild);
            if (root.leftChild != null)
                list.add(root.leftChild);
            stack.push(root);
        }

        while (!stack.isEmpty())
        {
            System.out.print(stack.pop().data + " ");
        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(1);
        binaryTree.addNode(2);
        binaryTree.addNode(3);
        binaryTree.addNode(4);
        binaryTree.addNode(5);
        binaryTree.addNode(6);
        binaryTree.addNode(7);
        levelOrderReverse(binaryTree.root);
    }
}
