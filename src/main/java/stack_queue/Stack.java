package stack_queue;

/**
 * Created by srathi on 8/5/16.
 */
public class Stack<T> {

    int top;
    private T[] arr;
    private int size;

    public Stack(int size) {
        arr = (T[]) new Object[size];
        this.size = size;
        top = -1;
    }

    public void push(T item)
    {
        arr[++top] = item;

    }

    public T pop()
    {
        return arr[top--];

    }

    public boolean is_empty()
    {
        return top == -1;
    }

    public boolean is_full()
    {
        return top == size -1;
    }

    public T peek()
    {
        return arr[top];
    }

    public static void main(String[] args) {
        Stack a  = new Stack(2);
        a.push(10);
        a.push(20);
        System.out.println(a.is_full());
        while (!a.is_empty())
        {
            Integer b = (Integer) a.pop();
            System.out.println(b);
        }

        Stack b  = new Stack(2);
        b.push('b');
        b.push('c');
        System.out.println(b.is_full());
        while (!b.is_empty())
        {
            Character c = (Character) b.pop();
            System.out.println(c);
        }

    }

}
