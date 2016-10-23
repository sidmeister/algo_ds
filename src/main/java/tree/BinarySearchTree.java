package tree;

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
        while(current.data != temp)
        {
            if(current.data > temp)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return false;
        }
        return true;

    }

    public Node lowestCommonAncestor(Node root, int val1, int val2)
    {

        if (root.data > val1 && root.data < val2){
            return root;
        }
        else if (root.data > val1 && root.data > val2){
            return lowestCommonAncestor(root.leftChild, val1, val2);
        }
        else if (root.data < val1 && root.data < val2){
            return lowestCommonAncestor(root.rightChild, val1, val2);
        }

        return root;
    }

    public void addNode(int temp)
    {
        Node newNode = new Node();
        newNode.data = temp;
       // newNode.data = temp;
        if (root ==null) //root is empty insert here
        {
            root = newNode;
            System.out.println("Added root " + root.data);
        }
        else
        {
            Node current = root;
            while (true)
            {
                Node parent = current;
                if (current.data >= temp) //temp is lower than temp so move to left subtree
                {
                    current = current.leftChild;
                    if (current == null) //we have reached where to insert the node
                    {
                        System.out.println("Adding " + temp + " to left of " + parent.data);
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else //move to right subtree
                {
                    current = current.rightChild;
                    if (current == null) //we have reached where to insert the node
                    {
                        System.out.println("Adding "  + newNode.data + " to right of " + parent.data);
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }


}
