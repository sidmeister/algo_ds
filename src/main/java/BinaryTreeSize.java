import java.util.LinkedList;

/**
 * Created by srathi on 11/25/16.
 * calculate the number of nodes in a binary tree
 *
 */
public class BinaryTreeSize {

    public static int sizeRecursion(Node root)
    {
        if (root == null)
            return 0;
        else return (1 + sizeRecursion(root.leftChild) + sizeRecursion(root.rightChild));
    }

    public static int sizeNonRecursion(Node root)
    {
        if (root == null)
            return 0;
        int count = 0;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node current = list.pop();
            count++;
            if (current.leftChild != null) {
                list.add(current.leftChild);
            }
            if (current.rightChild != null) {
                list.add(current.rightChild);
            }
        }
        return count;
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        System.out.println(sizeRecursion(binaryTree.root));
        System.out.println(sizeNonRecursion(binaryTree.root));

    }
}
