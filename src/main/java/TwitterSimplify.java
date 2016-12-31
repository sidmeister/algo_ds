import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by srathi on 12/6/16.
 */

class TwNode
{
    char data;
    ArrayList<TwNode> childs = new ArrayList<>();

    public void addchild(TwNode child)
    {
        childs.add(child);
    }
}

class TwTree
{
    TwNode root;

    public void addNode(TwNode node)
    {
        root.addchild(node);
    }
}

public class TwitterSimplify {

    public static void main(String[] args) {
        String input = "(AB)C((DE)F)";
        TwTree tree = new TwTree();
        Stack<Character> stack = new Stack<>();
        char[] in = input.toCharArray();
        for(int i =0;i<in.length;i++)
        {
            if(in[i]!= '(')
                stack.push(in[i]);
            else if(in[i] == ')')
            {
                TwTree subtree = new TwTree();
                subtree.root.data = '*';
                while(stack.pop() != '(' && !stack.isEmpty())
                {
                    TwNode t= new TwNode();
                    t.data = stack.pop();
                    subtree.root.addchild(t);
                }
                tree.addNode(subtree.root);
            }
            else
            {
                TwNode t= new TwNode();
                t.data = in[i];

            }

        }

    }
}
