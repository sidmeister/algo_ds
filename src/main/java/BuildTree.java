/**
 * Created by srathi on 11/26/16.
 *
 * Construct binary tree from given inorder and preorder traversals
 *
 * Inorder sequence :  D B E A F C
 * Preorder sequence : A B D E C F
 *
 */

public class BuildTree {

    static int  preorderindex =0;
    static int  postorderindex =7;
    public static Node buildTree_pre_inorder(int[] inorder, int[] preorder, int inorder_start, int inorder_end)
    {

        if (inorder_start > inorder_end)
            return null;

        Node newNode = new Node();
        newNode.data = preorder[preorderindex++];



        if (inorder_start == inorder_end)
            return newNode;

        int inorderIndex = search(newNode.data, inorder);

        newNode.leftChild =  buildTree_pre_inorder(inorder,preorder, inorder_start, inorderIndex -1);
        newNode.rightChild = buildTree_pre_inorder(inorder,preorder,inorderIndex +1, inorder_end);
        return newNode;
    }

    public static Node buildTree_post_inorder(int[] inorder, int[] preorder, int inorder_start, int inorder_end)
    {

        if (inorder_start > inorder_end)
            return null;

        Node newNode = new Node();
        newNode.data = preorder[postorderindex];
        postorderindex--;


        if (inorder_start == inorder_end)
            return newNode;

        int inorderIndex = search(newNode.data, inorder);

        newNode.rightChild = buildTree_post_inorder(inorder,preorder,inorderIndex +1, inorder_end);
        newNode.leftChild =  buildTree_post_inorder(inorder,preorder, inorder_start, inorderIndex -1);
        return newNode;
    }

    public static int search(int data, int[] inorder)
    {
        for(int i =0; i < inorder.length; i++)
        {
            if (inorder[i] == data)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        //Character[] inorder = new Character[]{'D','B','E','A','F','C'};
//        Character[] preorder = new Character[]{'A','B','D','E','C','F'};
        int[] inorder  = new int[]{4,8,2,5,1,6,3,7};
        int[] postorder = new int[]{8,4,5,2,6,7,3,1};
       // Node t = buildTree_pre_inorder(inorder,preorder,0,5);

        Node t = buildTree_post_inorder(inorder,postorder,0,7);
        BinaryTree tree = new BinaryTree();
        tree.root = t;
        TreeTraversals.preOrderRecursion(t);

    }
}
