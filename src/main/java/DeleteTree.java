/**
 * Created by srathi on 11/25/16.
 * delete a tree
 */
public class DeleteTree {

    /*
    before we delete the root we should delete the left subtree and right subtree
    1) delete left subtree
    2) delete right subtree
    3) delete root;

    so it is postorder traversal
     */

    public static void deleteTree(Node root)
    {
        if (root == null)
            return;
        deleteTree(root.leftChild);
        deleteTree(root.rightChild);
        root = null;
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
        TreeTraversals.inOrderNonRecursion(binaryTree.root);
    }
}
