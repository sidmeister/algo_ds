/**
 * Created by srathi on 1/4/17.
 */

    // input 1: <3,5>, <7,9>, <12,15>
// input 2: <4, 8>
// output:  <3, 9>, <12,15>

// input 2: <1,2>
// output: <1,2>, <3,5>, <7,9>, <12,15>

// input 2: <1,6>
// output: <1,6>, <7,9>, <12,15>


// input 2: <1,21>
// output: <1, 21>


// scenario 1: input2.end < interval.start => insert input2, insert everything else afterwards from input
// scenario 2: interval.end < input2.start => insert the interval
// scenario 3: intersection, need to figure out what to do



// input 1: <3,5>, <7,9>, <12,15>
// input 2: <4, 8>
// output:  <3, 9>, <12,15>

// input 2: <1,2>
// output: <1,2>, <3,5>, <7,9>, <12,15>

// input 2: <1,6>
// output: <1,6>, <7,9>, <12,15>


// input 2: <1,21>
// output: <1, 21>


// scenario 1: input2.end < interval.start => insert input2, insert everything else afterwards from input
// scenario 2: interval.end < input2.start => insert the interval
// scenario 3: intersection, need to figure out what to do

import java.io.*;
import java.util.*;
import java.util.Stack;


class Interval {
    int start;
    int end;
    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

    public class Lyft {

        public static void  merge(ArrayList<Interval> input,Interval input2)
        {
            Stack<Interval> stk = new Stack<>();
            //ArrayList<Interval> output = new ArrayList<>();

            // input 1: <3,5>, <7,9>, <12,15>
            // input 2: <4, 8>
            // output:  <3, 9>, <12,15>

            stk.push(input2);
            for(Interval interval : input)
            {
                Interval top = stk.peek();
                if(top.end < interval.start)
                {
                    stk.push(interval);
                }
                else
                {
                    if(interval.start < top.start)
                    {
                        top.start = interval.start;
                        stk.pop();
                        stk.push(top);
                    }
                    if(top.end < interval.end)
                    {
                        top.end = interval.end;
                        stk.pop();
                        stk.push(top);
                    }
                }
            }
            while (!stk.isEmpty())
            {
                Interval t = stk.pop();
                System.out.println("[" + t.start + "," + t.end + "]");
            }

        }


        public static void main(String[] args) {
            ArrayList<Interval> input = new ArrayList<Interval>();
            Interval i1 = new Interval(3,5);
            Interval i2 = new Interval(7,9);
            Interval i3 = new Interval(12,15);
            Interval toInsert = new Interval(1,6);

            input.add(i1);
            input.add(i2);
            input.add(i3);

            merge(input, toInsert);

        }

}
