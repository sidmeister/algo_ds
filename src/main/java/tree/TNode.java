package tree;

/**
 * Created by srathi on 8/27/2016.
 */
public class TNode<T  extends Comparable<T>>  implements Comparable<TNode <T>> {

    private T data;
    TNode<T> leftChild; //leftchild
    TNode<T> rightChild; //rightChild

    public TNode(T data) {
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
    public int compareTo(TNode<T> other) {
        return this.getData().compareTo(other.data);
    }
}
