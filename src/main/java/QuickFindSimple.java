/**
 * Created by Siddharth on 1/7/2017.
 * time complexity o(n^2)
 * array index is the component that the element is in
 * eager approach
 */
public class QuickFindSimple {
    public int[] arr = new int[10];


    public QuickFindSimple() {
        for(int i =0; i < arr.length;i++)
            arr[i] = i;
    }

    public void union(int to, int from)
    {
        for(int i =0;i< arr.length;i++)
        {
            if(arr[i] == to)
                arr[i] = arr[from];
        }

    }

    public void display()
    {
        for(int i =0;i< arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

    }

    public boolean connected(int p,int q)
    {
       return arr[p] == arr[q];

    }

    public static void main(String[] args) {

        QuickFindSimple UF = new QuickFindSimple();
        UF.union(4,3);
        UF.union(3,8);
        UF.union(6,5);
        UF.union(9,4);
        UF.union(2,1);
        UF.display();
        System.out.println(UF.connected(8,9));
        System.out.println(UF.connected(5,0));

    }
}
