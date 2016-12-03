package tree.binaryTree;

import tree.Node;

/**
 * Created by srathi on 11/26/16.
 *
 * Construct binary tree from given inorder and preorder traversals
 *
 * Inorder sequence :  D B E A F C
 * Preorder sequence : A B D E C F
 *
 */

public class BuildTree {

    static int  preorderindex =0;
    public static Node buildTree(Character[] inorder, Character[] preorder, int inorder_start, int inorder_end)
    {

        if (inorder_start > inorder_end)
            return null;

        Node newNode = new Node();
        newNode.data = preorder[preorderindex++];



        if (inorder_start == inorder_end)
            return newNode;

        int inorderIndex = search(newNode.data, inorder);

        newNode.leftChild =  buildTree(inorder,preorder, inorder_start, inorderIndex -1);
        newNode.rightChild = buildTree(inorder,preorder,inorderIndex +1, inorder_end);
        return newNode;
    }

    public static int search(int data, Character[] inorder)
    {
        for(int i =0; i < inorder.length; i++)
        {
            if (inorder[i] == data)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Character[] inorder = new Character[]{'D','B','E','A','F','C'};
        Character[] preorder = new Character[]{'A','B','D','E','C','F'};
        Node t = buildTree(inorder,preorder,0,5);
        BinaryTree tree = new BinaryTree();
        tree.root = t;
        TreeTraversals.inOrderNonRecursion(t);

    }
}
