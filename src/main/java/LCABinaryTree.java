/**
 * Created by srathi on 11/25/16.
 */
public class LCABinaryTree {

    public static Node LCA(Node root,Node a, Node b)
    {
        Node left;
        Node right;

        if (root == null)
            return root;
        if (root.data == a.data || root.data == b.data)
            return root;
        left = LCA(root.leftChild,a,b);
        right = LCA(root.rightChild, a,b);
        if(left!= null && right!=null)
            return root;
        else {
            if (left != null) return left;
            else return right;
        }

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
        Node A = new Node();
        A.data = 7;
        Node B = new Node();
        B.data = 8;
        Node lca = LCA(binaryTree.root, A,B);
        System.out.println(lca.data);

    }
}
