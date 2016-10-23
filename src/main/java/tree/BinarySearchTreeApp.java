package tree;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class BinarySearchTreeApp {

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(4);
        binaryTree.addNode(2);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
        binaryTree.addNode(6);
        if (binaryTree.findNode(8))
            System.out.println("node exists");
        Node lca = binaryTree.lowestCommonAncestor(binaryTree.root,1, 7);
        System.out.println("lca is: " + lca.data);
    }
}
