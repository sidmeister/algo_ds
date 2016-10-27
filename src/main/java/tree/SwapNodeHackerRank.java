package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by srathi on 10/22/16.
 */

class BST {

    Node root; //Tree class only nends to know about the root

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }

    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.leftChild);
            int rDepth = maxDepth(node.rightChild);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public BST(Node root) {
        this.root = root;
    }
}

public class SwapNodeHackerRank {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int array_length = input.nextInt() * 2;
        int[] arr = new int[array_length];
        String line;
        int index = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (input.hasNextInt() && array_length > 0) {
            list.add(input.nextInt());
            array_length--;
        }
        int j = 0;
        for (Integer i: list)
        {
            arr[j] = i;
            j++;
        }
        list.clear();
        int number_of_depths = input.nextInt();
        while (input.hasNextInt()) {
            list.add(input.nextInt());
        }
        Node root = new Node();
        root.data = 1;
        int treedepth = 1;
        BST tree = new BST(root);
        LinkedList<Node> linklist = new LinkedList<>();
        linklist.add(root);
        for (int i = 0; i < arr.length; i = i+2 ) {
            Node head  = linklist.poll();
            if (arr[i] != -1)
            {
                Node left  = new Node();
                left.data = arr[i];
                head.leftChild = left;
                linklist.add(left);

            }
            else
                head.leftChild = null;

            if (arr[i +1] != -1)
            {
                Node right  = new Node();
                right.data = arr[i+1];
                head.rightChild = right;
                linklist.add(right);
            }
            else
                head.rightChild = null;
        }
        treedepth = tree.maxDepth(root);
        for (Integer d:list)
        {
            int k = d;
            int l = 1;
            while ( (k*l) < treedepth) {
                linklist.clear();
                drill(root, 1, k*l, linklist);
                for (int i = 0; i < linklist.size(); i++) {
                    Node temp = linklist.get(i).leftChild;
                    linklist.get(i).leftChild = linklist.get(i).rightChild;
                    linklist.get(i).rightChild = temp;
                }
                l++;
            }
            tree.inOrder(root);
            System.out.print("\n");
        }


    }

    /*
 * node - node being visited
 * clevel - current level
 * rlevel - requested level
 * result - result queue
 */
    public static void drill (Node node, int clevel, int rlevel, LinkedList<Node> result) {
        if (clevel == rlevel) {
            result.add(node);
        }
            else {
                if (node.leftChild != null)
                    drill (node.leftChild, clevel + 1, rlevel, result);
                if (node.rightChild != null)
                    drill (node.rightChild, clevel + 1, rlevel, result);
            }
        }
}
