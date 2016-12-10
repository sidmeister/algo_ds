package tree.binaryTree;

import tree.Node;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by srathi on 12/8/16.
 * Given a simple expression tree, consisting of basic binary operators i.e., + , – ,* and / and some integers,
 * evaluate the expression tree.
 */

class ENode {

    public String data;
    public ENode leftChild; //leftchild
    public ENode rightChild; //rightChild
}


public class EvaluationExpressionTree {

    public static Integer inOrderRecursion(ENode localRoot)
    {

        if (localRoot.leftChild == null && localRoot.rightChild== null)
        return new Integer(localRoot.data);
        int l_val = inOrderRecursion(localRoot.leftChild);
        int r_val = inOrderRecursion(localRoot.rightChild);
        if (localRoot.data=="+")
            return l_val+r_val;

        if (localRoot.data=="-")
            return l_val-r_val;

        if (localRoot.data=="*")
            return l_val*r_val;
        return l_val/r_val;
    }

    public static void main(String[] args) {
        ENode root = new ENode();
        root.data = "+";
        ENode e1 = new ENode();
        e1.data="*";
        root.leftChild = e1;
        ENode e2 = new ENode();
        e2.data ="-";
        root.rightChild = e2;

        ENode e3 = new ENode();
        e3.data ="5";
        e1.leftChild = e3;
        ENode e4 = new ENode();
        e4.data ="4";
        e1.rightChild = e4;


        ENode e5 = new ENode();
        e5.data ="100";
        e2.leftChild = e5;
        ENode e6 = new ENode();
        e6.data = "20";
        e2.rightChild = e6;
        System.out.println(inOrderRecursion(root));
    }


}
