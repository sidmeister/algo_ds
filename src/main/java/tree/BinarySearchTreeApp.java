package tree;

/**
 * Created by Siddharth on 8/27/2016.
 */
public class BinarySearchTreeApp {

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.addNode(10);
        binaryTree.addNode(20);
        binaryTree.addNode(30);
        binaryTree.addNode(15);
        binaryTree.addNode(5);
        binaryTree.addNode(8);
        if(binaryTree.findNode(8))
            System.out.println("node exists");
    }
}
