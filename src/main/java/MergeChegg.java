/**
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


class CheggObj
{
int timestamp;
int value;

    public CheggObj()
    {
    }

public CheggObj(int t, int v)
{
    this.timestamp = t;
    this.value = v;
}
}

public class MergeChegg {

        public static ArrayList<CheggObj> mergesort(ArrayList<CheggObj> A,ArrayList<CheggObj> B)
        {
            int aptr = 0, bptr = 0;
            ArrayList<CheggObj> sorted = new ArrayList<>();
            while ( aptr < A.size() && bptr < B.size())
            {
                if (A.get(aptr).timestamp < B.get(bptr).timestamp)
                {

                    sorted.add(A.get(aptr));
                    aptr++;
                }
                else if (A.get(aptr).timestamp == B.get(bptr).timestamp)
                {
                    CheggObj t = new CheggObj();
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
        ArrayList<CheggObj> A = new ArrayList<>();
        ArrayList<CheggObj> B = new ArrayList<>();
            A.add(new CheggObj(0, 17));
            A.add(new CheggObj(2, 7));
            A.add(new CheggObj(7, 7));
            A.add(new CheggObj(10, 4));

        B.add(new CheggObj(2, 3));
        B.add(new CheggObj(8, 8));
        ArrayList<CheggObj> C = mergesort(A,B);
       for (CheggObj t : C)
       {
           System.out.println(t.timestamp + "," + t.value);
       }

    }

    }
