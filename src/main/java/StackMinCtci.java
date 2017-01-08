/**
 * Created by srathi on 12/2/16.
 *
 * How would you design a stack which in addition to pop and push has a function min which returns
 * the min element. Push pop and min should all operate in O(1)
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 *
 */

class Sobj
{
    public int min = 0;
    public int value;

    public Sobj(int value)
    {
        this.value = value;
    }

}



class StackSMin {

    int top;
    private Sobj[] arr;
    private int size;


    public StackSMin(int size) {
        arr = new Sobj[size];
        this.size = size;
        top = -1;
    }

    public void push(int item)
    {
        Sobj p = new Sobj(item);
        if(is_empty()) {
            p.min = item;
        }
        else
        {
            Sobj minTop = peek();
            if (minTop.min < item)
                p.min = minTop.min;
            else
                p.min = item;
        }
        arr[++top] = p;
    }

    public Sobj pop()
    {
        return arr[top--];

    }

    public int min()
    {
        return peek().min;

    }


    public boolean is_empty()
    {
        return top == -1;
    }

    public boolean is_full()
    {
        return top == size -1;
    }

    public Sobj peek()
    {
        return arr[top];
    }
}


public class StackMinCtci {

    public static void main(String[] args) {

        StackSMin stack = new StackSMin(3);
        stack.push(10);
        stack.push(20);
        stack.push(5);
        System.out.println(stack.min());

    }
}
