/**
 * Created by srathi on 12/27/16.
 */

class BFSVertex
{
    char label;
    boolean visited = false;
    public BFSVertex(char label)
    {
        this.label = label;
    }

}

class BFSQueue
{
    private final int size = 20;
    private int[] arr;
    private int front,rear,nELems;

    public BFSQueue()
    {
        arr = new int[size];
        nELems = 0;
        front = 0;
        rear = -1;
    }

    public void enQueue(int item)
    {
        if(!isFull())
        {
            arr[++rear] = item;
            nELems++;
        }
    }

    public int deQueue()
    {
        if(!isEmpty())
        {
            int item = arr[front++];
            nELems--;
            return item;
        }
        return -1;
    }

    public boolean isEmpty()
    {
        return nELems == 0;
    }

    public boolean isFull()
    {
        return nELems == size -1;
    }

}

class BFSGraph
{
    private final int MAX_VERTS = 20;
    private BFSVertex[] vertices;
    private int[][] adjMatrix;
    private int nVerts;
    private BFSQueue queue;

    public BFSGraph()
    {
        vertices = new BFSVertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int i=0;i<adjMatrix.length;i++)
        {
            for (int j=0;j<adjMatrix[0].length;j++)
            {
                adjMatrix[i][j] = 0;
            }
        }
        queue = new BFSQueue();
    }

    public void addVertex(char label)
    {

        vertices[nVerts++]= new BFSVertex(label);
    }

    public void addEdge(int start,int end)
    {

        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public int getAdjUnvisitedVertex(int item)
    {
        for(int j =0; j<nVerts;j++)
        {
            if(adjMatrix[item][j] == 1 && vertices[j].visited == false)
                return j;
        }
        return -1;
    }
    public void bfs()
    {
        int v2;
        vertices[0].visited = true;
        System.out.print(vertices[0].label);
        queue.enQueue(0);
        while(!queue.isEmpty())
        {
            int item = queue.deQueue();
            while((v2 =getAdjUnvisitedVertex(item)) != -1)
            {
                vertices[v2].visited = true;
                System.out.print(vertices[v2].label);
                queue.enQueue(v2);
            }
        }
        for(int j=0; j<nVerts; j++) // reset flags
            vertices[j].visited = false;

    }

}

public class BFSApp {

    public static void main(String[] args) {

        BFSGraph theGraph = new BFSGraph();
        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE
        theGraph.bfs();
    }
}
