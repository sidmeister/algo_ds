package datastructures;

/**
 * Created by srathi on 8/30/16.
 */
public class DequeLinkList {
        private DequeLink first;
        private DequeLink last;

        public DequeLinkList()
        {
            first = null;
            last = null;
        }
        public void insertFirst(int num)
        {
            DequeLink temp = new DequeLink(num);

            if (is_empty()) //inserting first link
            {
                last = temp;
            }
            temp.next = first;
            first = temp;
        }

        public int removeRight()
        {
            DequeLink temp = first;
            int num = last.number;
            if (first == last) //only 1 link
            {
                first = last = null;
                return  num;
            }
            while (temp.next != last)
            {
                temp = temp.next;
            }
            //System.out.println(temp.number);

            temp.next = last.next;
            last = temp;
            return  num;
        }

        public void insertLast(int num)
        {
            DequeLink temp = new DequeLink(num);
            if(is_empty())
            {
                first = temp;
            }
            else
                last.next = temp;
            last = temp;
        }

        public boolean is_empty()
        {
            return (first == null );

        }

        public void displayList()
        {
            DequeLink current = first;
            while (current != null)
            {
                System.out.print(current.number + "->");
                current = current.next;
            }
            //System.out.println("\n");

        }


    }
