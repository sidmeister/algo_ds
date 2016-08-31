package linklist;

/**
 * Created by srathi on 8/24/16.
 * Deque as a linked list
 */
public class DequeLLApp {

    public static void main(String[] args) {
        DequeLinkList theList = new DequeLinkList();
        theList.insertFirst(22);
//        theList.insertFirst(44);
//        theList.insertFirst(66);
//        theList.insertLast(11);
//        theList.insertLast(33);
//        theList.insertLast(55);
        theList.displayList();
        int rightmost = theList.removeRight();
        System.out.println(rightmost);
        theList.displayList();
    }

}


