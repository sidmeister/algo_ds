import java.util.*;

/*

Input: List of words
List1 = {i, am, test, i , six, two,i,two,one}


Q: Print Unique words in given list and sort by frequency.
Output: {I,two,am,test,six,one}

 */

class UArray
{
    private TObj[] theArray; // ref to array theArray
    private int nElems; // number of data items
    //-----------------------------------------------------------
    public UArray(TObj[] arr) // constructor
    {
        theArray = arr; // create array
        nElems = arr.length;
    }

    //-----------------------------------------------------------
    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(theArray[j].ch + " " ); // display character
        System.out.println("");
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(theArray[j].frequency + " " ); // display frequency
        System.out.println("");
    }
    //-----------------------------------------------------------
    public TObj[] mergeSort() // called by main()
    { // provides workspace
        TObj[] workSpace = new TObj[nElems];
        recMergeSort(workSpace, 0, nElems-1);
        return workSpace;
    }
    //-----------------------------------------------------------
    private void recMergeSort(TObj[] workSpace, int lowerBound,
                              int upperBound)
    {
        if(lowerBound == upperBound) // if range is 1,
            return; // no use sorting
        else
        { // find midpoint
            int mid = (lowerBound+upperBound) / 2; // sort low half
            recMergeSort(workSpace, lowerBound, mid); // sort high half
            recMergeSort(workSpace, mid+1, upperBound); // merge them
            merge(workSpace, lowerBound, mid+1, upperBound);
        } // end else
    } // end recMergeSort()
    //-----------------------------------------------------------
    private void merge(TObj[] workSpace, int lowPtr,
                       int highPtr, int upperBound)
    {
        int j = 0; // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // # of items
        while(lowPtr <= mid && highPtr <= upperBound)
            if( theArray[lowPtr].frequency > theArray[highPtr].frequency )
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    } // end merge()
//-----------------------------------------------------------
} // end class DArray
////////////////////////////////////////////////////////////////

class TObj
{
    String ch;
    int frequency;
}

public class SortByFrequenceUber {


    public static void main(String[] args) {

        ArrayList<String> input  = new ArrayList<>(Arrays.asList("i", "am", "test", "i" , "six", "two","i","two","one"));
        if (input.isEmpty() || input == null)
            return;
        Map<String, Integer> map = new HashMap<>();
        for (int i =0; i<input.size(); i++)
        {
            String ch = input.get(i);
            if (map.containsKey(ch))
            {
                int count = map.get(ch);
                count++;
                map.put(ch, count);
            }
            else
                map.put(ch,1);
        }

        //get the map values into an array
        TObj[] arr = new TObj[map.size()];

        int i =0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            TObj obj = new TObj();
            obj.ch = key;
            obj.frequency = value;
            arr[i] = obj;
            i++;
        }


        UArray dArray = new UArray(arr);
        //dArray.display();
        arr = dArray.mergeSort();
        //dArray.display();
        ArrayList<String> output = new ArrayList<>();
        for (int k=0; k<arr.length; k++)
        {
            TObj temp = arr[k];
            output.add(temp.ch);

        }

        System.out.println(output);

    }

}

