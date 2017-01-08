/**
 * Created by Siddharth on 1/7/2017.
 * Data structure = array
 * interpretation id[i] is parent of i
 * Root of i is id[id[id[...id[i]...]]] -- keep going until it doesn't change(algorithm ensures no cycles)
 * Extra size array to count number of objects in the tree rooted at i
 * Quick union weighted advantage
 * Trees are not too tall
 * Find too expensive (could be N array accesses)
 * Added path compression - just after computing the root of p set the id of each examined root to point to that root
 */
public class QuichUnionLazyWeighted {

    public int[] arr = new int[10];
    public int[] sz = new int[10];


    public QuichUnionLazyWeighted() {
        for(int i =0; i < arr.length;i++) {
            arr[i] = i;
            sz[i] = 1;
        }

    }

    /*
    * Union  - to merge components containing p and q, set the id of p's root to the id of q's root
     */
    private int root(int child)
    {
       while(child!= arr[child])
       {
           arr[child] = arr[arr[child]];
           child = arr[child];

       }
       return child;
    }

    /*
   * weighted Union  - to merge components containing p and q,
   * balance by linking root of smaller tree to root of larger tree
   *
    */
    public void union(int child, int parent)
    {
        int cid = root(child);
        int pid = root(parent);
        if(sz[cid] < sz[pid])
        {
            arr[cid] = pid;
            sz[pid]+= sz[cid];
        }
        else{
            arr[pid] = cid;
            sz[cid]+= sz[pid];
        }
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

        QuichUnionLazyWeighted UF = new QuichUnionLazyWeighted();
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
