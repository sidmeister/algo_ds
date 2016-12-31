/**
 * Created by srathi on 11/25/16.
 */
public class CommonAncestor {

    public static Node lowestCommonAncestor(Node root, int val1, int val2)
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

    public static void main(String[] args) {

        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        Node lca = lowestCommonAncestor(binaryTree.root,1, 7);
        System.out.println("lca is: " + lca.data);

    }
}
