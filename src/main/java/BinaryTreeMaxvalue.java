import java.util.LinkedList;

/**
 * Created by srathi on 11/25/16.
 */
public class BinaryTreeMaxvalue {

    public static int findMaxRecursion(Node localRoot)
    {
        int root_Val = 0;
        int leftmax = Integer.MIN_VALUE ,rightmax = Integer.MIN_VALUE,MAX = Integer.MIN_VALUE;
        if(localRoot!=null)
        {
            root_Val = localRoot.data;
            leftmax = findMaxRecursion(localRoot.leftChild);
            rightmax = findMaxRecursion(localRoot.rightChild);
        }
        if (leftmax > rightmax)
            MAX = leftmax;
        else
            MAX = rightmax;
        if (root_Val > MAX)
            MAX = root_Val;
        return MAX;
    }

    public static int findMax(Node localRoot)
    {
        int max = Integer.MIN_VALUE;
            LinkedList<Node> list = new LinkedList<>();
            while (localRoot != null)
            {
                if (max < localRoot.data)
                    max = localRoot.data;
                if (localRoot.leftChild != null)
                    list.add(localRoot.leftChild);
                if (localRoot.rightChild != null)
                    list.add(localRoot.rightChild);
                localRoot = list.poll();
            }
        return max;
    }

    public static void main(String[] args) {

        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        System.out.println(findMaxRecursion(binaryTree.root));
        System.out.println(findMax(binaryTree.root));

    }
}
