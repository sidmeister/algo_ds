package tree.binaryTree;


import tree.Node;
import tree.binaryTree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by srathi on 11/25/16.
 */
public class TreeTraversals {

    /*

    1. Call itself to traverse the node’s left subtree.
    2. Visit the node.
    3. Call itself to traverse the node’s right subtree.

     */

    public static void inOrderRecursion(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrderRecursion(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            inOrderRecursion(localRoot.rightChild);
        }
    }

    public static void inOrderNonRecursion(Node localRoot)
    {
        Stack<Node> stack = new Stack<>();
        while (true)
        {
        while (localRoot != null) {
            stack.push(localRoot);
            localRoot = localRoot.leftChild;
        }
            if(stack.isEmpty())
                break;
        localRoot = stack.pop();
        System.out.print(localRoot.data + " ");
        localRoot = localRoot.rightChild;
        }
    }

    /*
    in level order traversal, we visit the nodes level by level from left to right.
    You only have to complete the function.
    For example:

               3
             /   \
           5      2
           / \    /
         1   4   6

    For the above tree, the level order traversal is 3 -> 5 -> 2 -> 1 -> 4 -> 6.

    */

    public static void levelOrder(Node localRoot)
    {
        LinkedList<Node> list = new LinkedList<>();
        while (localRoot != null)
        {
            System.out.print(localRoot.data + " ");
            if (localRoot.leftChild != null)
                list.add(localRoot.leftChild);
            if (localRoot.rightChild != null)
                list.add(localRoot.rightChild);
            localRoot = list.poll();


        }
    }

    /*
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

    public void levelOrderReverse(Node root)
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



     /*

    1. Call itself to traverse the node’s left subtree.
    2. Call itself to traverse the node’s right subtree.
    3. Visit the node.
     */

    public static void postOrderNonRecursion(Node localRoot)
    {
        Stack<Node> stack = new Stack<>();
        stack.push(localRoot);
        Node previous = null;
        while (!stack.isEmpty())
        {
            Node current = stack.peek();
            if( previous == null || previous.leftChild == current || previous.rightChild == current)
            {
                if(current.leftChild != null)
                    stack.push(current.leftChild);
                else if(current.rightChild != null)
                    stack.push(current.rightChild);
            }
            else if(current.leftChild ==previous)
            {
                if (current.rightChild!= null)
                {
                    stack.push(current.rightChild);
                }
            }
            else
            {
                System.out.print(current.data + " ");
                stack.pop();
            }
            previous = current;

        }
    }

    public static void postOrderRecursion(Node localRoot)
    {
        if (localRoot != null)
        {
            postOrderRecursion(localRoot.leftChild);
            postOrderRecursion(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }

    /*
    1. Visit the node.
    2. Call itself to traverse the node’s left subtree.
    3. Call itself to traverse the node’s right subtree.
     */

    public static void preOrderRecursion(Node localRoot)
    {
        if (localRoot != null)
        {
            System.out.print(localRoot.data + " ");
            preOrderRecursion(localRoot.leftChild);
            preOrderRecursion(localRoot.rightChild);
        }
    }


    public static void preOrderNonRecursion(Node localRoot)
    {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (localRoot != null) {
                System.out.print(localRoot.data + " ");
                stack.push(localRoot);
                localRoot = localRoot.leftChild;
            }
            if (!stack.isEmpty()) {
                localRoot = stack.pop();
                localRoot = localRoot.rightChild;
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        System.out.print("Preorder:");
        preOrderRecursion(binaryTree.root);
        System.out.print("\n");
        System.out.print("Inorder:");
        inOrderRecursion(binaryTree.root);;
        System.out.print("\n");
        System.out.print("PostOrder:");
        postOrderNonRecursion(binaryTree.root);
        System.out.print("\n");
        System.out.print("Levelorder:");
        levelOrder(binaryTree.root);

    }
}
