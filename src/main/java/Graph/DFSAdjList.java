package Graph;

/**
 * Created by srathi on 11/26/16.
 */

class DFSLink
{
    public int vertex;
    public DFSLink next;
}

class DFSLinkList
{
    DFSLink head;
    public DFSLinkList()
    {
        head = new DFSLink();
        //head is given a dummy value so searches
        //don't necessarily include vertex A (0)
        head.vertex = -1;
    }

    public void insert(int v)
    {
        DFSLink cur = head;
        while(cur.next != null)
            cur = cur.next;
        cur.next = new DFSLink();
        cur.next.vertex = v;
    }

}


class GraphAdjList
{
    Vertex[] vertices;
    DFSLinkList[] adjMat;
    private final int MAX_VERTS = 20;
    private int nVerts;

    public GraphAdjList()
    {
        vertices = new Vertex[MAX_VERTS];
        adjMat = new DFSLinkList[MAX_VERTS];
        nVerts = 0;
        for(int j = 0; j < MAX_VERTS; j++)
            adjMat[j] = new DFSLinkList();
        //theStack = new StackX();
    }

    public void addVertex(char lab)
    {
        vertices[nVerts++] = new Vertex(lab);
    }

    //creates an edge from one vertex to another.
    //DIRECTED GRAPH, not undirected
    public void addEdge(int start, int end)
    {
        adjMat[start].insert(end);
    }

}

public class DFSAdjList {
}
