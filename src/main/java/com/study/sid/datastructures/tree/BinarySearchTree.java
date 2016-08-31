package com.study.sid.datastructures.tree;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class BinarySearchTree {

    Node root; //Tree class only nends to know about the root

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean findNode(int temp)
    {
        Node current = root;
        Node tNode = new Node(temp);
        while(current.compareTo(tNode)!=0)
        {
            System.out.println(current.getData());
            if(current.compareTo(tNode) == 1)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return false;
        }
        return true;

    }

    public void addNode(int temp)
    {
        Node newNode = new Node(temp);
       // newNode.data = temp;
        if (root ==null) //root is empty insert here
        {
            root = newNode;
            System.out.println("Added root " + root.getData());
        }
        else
        {
            Node current = root;
            while (true)
            {
                Node parent = current;
                if (current.compareTo(temp) >= 0) //temp is lower than temp so move to left subtree
                {
                    current = current.leftChild;
                    if (current == null) //we have reached where to insert the node
                    {
                        System.out.println("Adding " + newNode.getData() + " to left of " + parent.getData());
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else //move to right subtree
                {
                    current = current.rightChild;
                    if (current == null) //we have reached where to insert the node
                    {
                        System.out.println("Adding "  + newNode.getData() + " to right of " + parent.getData());
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }


}
