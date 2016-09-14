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

    public T peekN(int n)  // return item at index n
    { return arr[n]; }

    public int size()         // return size
    { return top+1; }

    public void displayStack()
    {
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }
}
