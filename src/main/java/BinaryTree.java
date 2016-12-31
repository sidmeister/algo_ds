import java.util.LinkedList;

/**
 * Created by srathi on 11/25/16.
 */
public class BinaryTree {

    Node root; //Tree class only nends to know about the root

    public BinaryTree() {
        this.root = null;
    }

    public int findMaxRecursion(Node localRoot)
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

     /*
    before we delete the root we should delete the left subtree and right subtree
    1) delete left subtree
    2) delete right subtree
    3) delete root;

    so it is postorder traversal
     */

    public void deleteTree(Node root)
    {
        if (root == null)
            return;
        deleteTree(root.leftChild);
        deleteTree(root.rightChild);
        root = null;
    }

    public int findMax(Node localRoot)
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

    /*
    1) ht left subtree
    2) ht right subtree
    3) delete root;

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

    public void addNode(int temp) {
        Node newNode = new Node();
        newNode.data = temp;
        // newNode.data = temp;
        if (root == null) //root is empty insert here
        {
            root = newNode;
            return;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node current = list.pop();
            if (current.leftChild != null) {
                list.add(current.leftChild);
            }
            else {
                current.leftChild = newNode;
                list.clear();
                break;
            }
            if (current.rightChild != null) {
                list.add(current.rightChild);
            }
            else {
                current.rightChild = newNode;
                list.clear();
                break;
            }
        }
        list = null;
    }

    public int findNode(Node root,int temp)
    {
        // newNode.data = temp;
        if (root == null) //root is empty insert here
            return -1;
        if (root.data == temp)
            return root.data;

        Node newNode = new Node();
        newNode.data = temp;

        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node current = list.pop();
            if (current.data == temp)
                return current.data;
            if (current.leftChild != null) {
                list.add(current.leftChild);
            }
            if (current.rightChild != null) {
                list.add(current.rightChild);
            }
        }
        list = null;
        return -1;
    }

    public int sizeRecursion(Node root)
    {
        if (root == null)
            return 0;
        else return (1 + sizeRecursion(root.leftChild) + sizeRecursion(root.rightChild));
    }

    public  int sizeNonRecursion(Node root)
    {
        if (root == null)
            return 0;
        int count = 0;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node current = list.pop();
            count++;
            if (current.leftChild != null) {
                list.add(current.leftChild);
            }
            if (current.rightChild != null) {
                list.add(current.rightChild);
            }
        }
        return count;
    }

    public int findNodeRecursion(Node root,int data)
    {
        Node current = root;
        int temp;
        if (current == null)
            return -1;

        if (current.data == data)
            return data;
        else {

            temp = findNodeRecursion(current.leftChild, data);
            if (temp >= 0)
                return temp;
            else return findNodeRecursion(current.rightChild, data);
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
        TreeTraversals.inOrderRecursion(binaryTree.root);
        System.out.print("\n");
        System.out.println(binaryTree.findNode(binaryTree.root,3));
        System.out.println(binaryTree.findNodeRecursion(binaryTree.root,3));
        System.out.println(binaryTree.findMaxRecursion(binaryTree.root));
        System.out.println(binaryTree.findMax(binaryTree.root));
        System.out.println(binaryTree.sizeRecursion(binaryTree.root));
        System.out.println(binaryTree.sizeNonRecursion(binaryTree.root));

    }
}
