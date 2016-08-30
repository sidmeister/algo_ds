package datastructures;

/**
 * Created by srathi on 8/12/16.
 */

    // linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////
    class Link
    {
        public int iData;              // data item
        public Link next;              // next link in list
        // -------------------------------------------------------------
        public Link(int id) // constructor
        {
            iData = id;                 // initialize data
        }                           //  set to null)
        // -------------------------------------------------------------
        public void displayLink()      // display ourself
        {
            System.out.print("{" + iData + "} ");
        }
    }  // end class Link
    ////////////////////////////////////////////////////////////////
    class LinkList
    {
        private Link first;            // ref to first link on list

        // -------------------------------------------------------------
        public LinkList()              // constructor
        {
            first = null;               // no links on list yet
        }
        // -------------------------------------------------------------
        public boolean isEmpty()       // true if list is empty
        {
            return (first==null);
        }
        // -------------------------------------------------------------
        // insert at start of list
        public void insertFirst(int id)
        {                           // make new link
            Link newLink = new Link(id);
            newLink.next = first;       // newLink --> old first
            first = newLink;            // first --> newLink
        }
        // -------------------------------------------------------------
        public Link deleteFirst()      // delete first item
        {                           // (assumes list not empty)
            Link temp = first;          // save reference to link
            first = first.next;         // delete it: first-->old next
            return temp;                // return deleted link
        }
        // -------------------------------------------------------------
        public void displayList()
        {
            System.out.print("List (first-->last): ");
            Link current = first;       // start at beginning of list
            while(current != null)      // until end of list,
            {
                current.displayLink();   // print data
                current = current.next;  // move to next link
            }
            System.out.println("");
        }

        // -------------------------------------------------------------
        public void reverseList()
        {
            System.out.print("List (first-->last): ");
            Link head = first;       // start at beginning of list
            Link previous = head;
            Link current = head.next;
            head.next = null;
            while(current != null)      // until end of list,
            {
                Link temp = current.next;
                //temp.displayLink();
                current.next = previous;
                previous = current;
                current = temp;
               // previous.displayLink();
            }
            first = previous;
            //System.out.println(head.next);

        }

// -------------------------------------------------------------
    }  // end class LinkList
    ////////////////////////////////////////////////////////////////
    class LinkListApp
    {
        public static void main(String[] args)
        {
            LinkList theList = new LinkList();  // make new list

            theList.insertFirst(22);      // insert four items
            theList.insertFirst(44);
            theList.insertFirst(66);
            theList.insertFirst(88);

            theList.displayList();              // display list
            theList.reverseList();
            theList.displayList();

           /* while( !theList.isEmpty() )         // until it's empty,
            {
                Link aLink = theList.deleteFirst();   // delete link
                System.out.print("Deleted ");         // display it
                aLink.displayLink();
                System.out.println("");
            }
            theList.displayList();              // display list*/
        }  // end main()
    }  // end class LinkListApp
////////////////////////////////////////////////////////////////


