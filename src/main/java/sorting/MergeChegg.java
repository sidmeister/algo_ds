package sorting; /**
 * Created by srathi on 12/2/16.
 */

import java.util.ArrayList;

/** Given two input lists of objects containing `timestamp` and `value` fields (both ints),
 merge the two lists together.  All lists follow the invariant that they are ordered by
 `timestamp` and that there are no duplicate `timestamp`s in a single list.  The output  list should follow this invariant as well; if you come across duplicate `timestamp`s
 while merging, you can de-dupe by adding the values together.

 ### Example
 (timestamp, value)
 Input A: [(0, 17), (2, 7), (7, 7), (10, 4)]
 Input B: [(2, 3), (8, 8)]
 Output:  [(0, 17), (2, 10), (7, 7), (8, 8), (10, 4)]
 **/


class Obj
{
int timestamp;
int value;

    public Obj()
    {
    }

public Obj(int t, int v)
{
    this.timestamp = t;
    this.value = v;
}
}

public class MergeChegg {

        public static ArrayList<Obj> mergesort(ArrayList<Obj> A,ArrayList<Obj> B)
        {
            int aptr = 0, bptr = 0;
            ArrayList<Obj> sorted = new ArrayList<>();
            while ( aptr < A.size() && bptr < B.size())
            {
                if (A.get(aptr).timestamp < B.get(bptr).timestamp)
                {

                    sorted.add(A.get(aptr));
                    aptr++;
                }
                else if (A.get(aptr).timestamp == B.get(bptr).timestamp)
                {
                    Obj t = new Obj();
                    t.timestamp = A.get(aptr).timestamp ;
                    t.value = A.get(aptr).value + B.get(bptr).value ;
                    sorted.add(t);
                    aptr++;
                    bptr++;
                }
                else
                {
                    sorted.add(B.get(bptr));
                    bptr++;
                }

            }

            while ( aptr < A.size())
            {
                sorted.add(A.get(aptr));
                aptr++;
            }

            while ( bptr < B.size())
            {
                sorted.add(B.get(bptr));
                bptr++;
            }

            return sorted;

        }

    public static void main (String[] args)
    {
        int i =0;
        ArrayList<Obj> A = new ArrayList<>();
        ArrayList<Obj> B = new ArrayList<>();
            A.add(new Obj(0, 17));
            A.add(new Obj(2, 7));
            A.add(new Obj(7, 7));
            A.add(new Obj(10, 4));

        B.add(new Obj(2, 3));
        B.add(new Obj(8, 8));
        ArrayList<Obj> C = mergesort(A,B);
       for (Obj t : C)
       {
           System.out.println(t.timestamp + "," + t.value);
       }

    }

    }
