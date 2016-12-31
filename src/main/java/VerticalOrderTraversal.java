/**
 * Created by srathi on 12/8/16.
 *
 *
 Print a Binary Tree in Vertical Order | Set 1

 Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

    1
  /    \
 2      3
 / \    / \
 4   5  6   7
 \   \
 8   9


 The output of print this tree vertically will be:
 4
 2
 1 5 6
 3 8
 7
 9

 print-binary-tree-in-vertical-order
 */

class values {
    int min;
    int max;
}

public class VerticalOrderTraversal {

    public static void findMinMax(Node root,values minmax,int hd)
    {
        if(root == null)
            return;

        if(hd < minmax.min)
            minmax.min = hd;
        else if(hd > minmax.max)
            minmax.max = hd;

        findMinMax(root.leftChild, minmax,hd-1);
        findMinMax(root.rightChild,minmax,hd+1);
    }

    public static void printVerticalLine(Node root, int line, int hd)
    {

        if(root == null)
            return;

        if(line == hd)
            System.out.print(root.data + " ");

        printVerticalLine(root.leftChild,line,hd-1);
        printVerticalLine(root.rightChild,line,hd+1);



    }

    public static void verticalOrder(Node root)
    {
        values minmax = new values();
        findMinMax(root,minmax,0);
        for(int i =minmax.min; i<=minmax.max;i++)
        {
            printVerticalLine(root,i,0);
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        verticalOrder(binaryTree.root);
    }
}
