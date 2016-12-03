package tree.binaryTree;

import tree.Node;

/**
 * Created by srathi on 11/26/16.
 */
public class PrintPathRoofToLeaf {

    public static void PrintPathRecur(Node root,int[]path,int pathlen )
    {

        if (root == null)
            return;
        path[pathlen++] = root.data;
        if (root.leftChild == null || root.rightChild == null)
            printPath(path,pathlen);
        PrintPathRecur(root.leftChild,path,pathlen);
        PrintPathRecur(root.rightChild,path,pathlen);
    }

    public static void printPath(int[]Path, int pathlen)
    {
        System.out.print("\n");
        for(int i=0; i <pathlen; i++)
            System.out.print(Path[i] + "->");
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(1);
        binaryTree.addNode(2);
        binaryTree.addNode(3);
        binaryTree.addNode(5);
        binaryTree.addNode(6);
        binaryTree.addNode(7);
        binaryTree.addNode(8);
        int[] path = new int[binaryTree.sizeRecursion(binaryTree.root)];
        PrintPathRecur(binaryTree.root,path,0);

    }
}
