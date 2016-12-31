import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class BinarySearchTree {

    Node root; //Tree class only nends to know about the root

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }



    /* Compute the "maxDepth" of a tree -- the number of
       nodes along the longest path from the root node
       down to the farthest leaf node.*/
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


    public static void topView(Node root)
    {
        Stack<Node> stk = new Stack<>();
        Node temp = root;
        if (root!=null)
            stk.push(root);
        while(root.leftChild!=null) {
            stk.push(root.leftChild);
            root = root.leftChild;
        }
        while(!stk.isEmpty())
            System.out.print(stk.pop().data + " ");
        root = temp;
        LinkedList<Node> queue = new LinkedList<>();
        while(root.rightChild!=null) {
            queue.add(root.rightChild);
            root = root.rightChild;
        }
        while(!queue.isEmpty())
            System.out.print(queue.pop().data);
    }

    public int getHeight(Node root)
    {
        if (root == null)
            return -1;
        int leftheight = getHeight(root.leftChild);
        int rightheight = getHeight(root.rightChild);
        if (leftheight > rightheight)
            return leftheight +1;
        return rightheight +1;



    }


    public int findNode(Node root, int temp)
    {
        Node current = root;
        while(current.data != temp)
        {
            if(current.data > temp)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return -1;
        }
        return current.data;

    }


    public void addNode(int temp)
    {
        Node newNode = new Node();
        newNode.data = temp;
       // newNode.data = temp;
        if (root ==null) //root is empty insert here
        {
            root = newNode;
//            System.out.println("Added root " + root.data);
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
//                        System.out.println("Adding " + temp + " to left of " + parent.data);
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else //move to right subtree
                {
                    current = current.rightChild;
                    if (current == null) //we have reached where to insert the node
                    {
//                        System.out.println("Adding "  + newNode.data + " to right of " + parent.data);
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
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
        System.out.print("\n");
        System.out.println(binaryTree.getHeight(binaryTree.root));
        System.out.println(binaryTree.findNode(binaryTree.root,3));
        topView(binaryTree.root);
    }


}
