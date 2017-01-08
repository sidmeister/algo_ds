/**
 * Created by Siddharth on 1/7/2017.
 * Data structure = array
 * interpretation id[i] is parent of i
 * Root of i is id[id[id[...id[i]...]]] -- keep going until it doesn't change(algorithm ensures no cycles)
 * Quick union defect
 * Trees can get too tall
 * Find too expensive (could be N array accesses)
 *
 */
public class QuichUnionLazy {

    public int[] arr = new int[10];


    public QuichUnionLazy() {
        for(int i =0; i < arr.length;i++)
            arr[i] = i;
    }

    /*
    * Union  - to merge components containing p and q, set the id of p's root to the id of q's root
     */
    private int root(int child)
    {
       while(child!= arr[child])
       {
           child = arr[child];
       }
       return child;
    }

    /*
   * Union  - to merge components containing p and q, set the id of p's root to the id of q's root
    */
    public void union(int child, int parent)
    {
        int cid = root(child);
        int pid = root(parent);
        arr[cid] = pid;
        this.display();
    }

    public void display()
    {
        for(int i =0;i< arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");

    }

    /*
    Find -  check if p and q have the same root i.n are they in the same component
     */
    public boolean connected(int p,int q)
    {
        return root(p) == root(q);

    }

    public static void main(String[] args) {

        QuichUnionLazy UF = new QuichUnionLazy();
        UF.union(4,3);
        UF.union(3,8);
        UF.union(6,5);
        UF.union(9,4);
        UF.union(2,1);
        System.out.println(UF.connected(8,9));
        System.out.println(UF.connected(5,4));
        UF.union(5,0);
        UF.union(7,2);
        UF.union(6,1);
        UF.union(7,3);
        System.out.println(UF.connected(8,9));
        System.out.println(UF.connected(5,4));

    }
}
