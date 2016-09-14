package stack_queue;

/**
 * Created by Siddharth on 9/13/2016.
 */
public class StackApp {

    public static void main(String[] args) {
        Stack a  = new Stack(2);
        a.push(10);
        a.push(20);
        a.displayStack();
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
