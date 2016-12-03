package tree.binaryTree;

import tree.Node;

/**
 * Created by srathi on 11/25/16.
 * delete a tree
 */
public class BinaryTreeHeight {

    /*
    1) ht left subtree
    2) ht right subtree
    so it is preorder traversal
     */

    public static int height(Node root)
    {
        if (root == null)
            return 0;
        int leftht= height(root.leftChild);
        int rightht = height(root.rightChild);
        if (leftht > rightht)
            return (leftht + 1);
        else
            return (rightht + 1);

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
        System.out.println(height(binaryTree.root));
    }
}
