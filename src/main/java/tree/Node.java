package tree;

/**
 * Created by Ashu on 8/27/2016.
 */
public class Node<T  extends Comparable<T>>  implements Comparable<Node <T>> {

    private T data;
    Node<T> leftChild; //leftchild
    Node<T> rightChild; //rightChild

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void displayNode(T temp) {
        System.out.println(temp);
    }

    public int compareTo(T other) {
        return  (this.data.compareTo(other));
    }

    @Override
    public int compareTo(Node<T> other) {
        return this.getData().compareTo(other.getData());
    }
}
