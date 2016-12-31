/**
 * Created by srathi on 11/20/16.
 */
public class Graph {

    public static final int MAX_VERTS = 10;
    public Vertex[] vertices;
    public int[][] adj_matrix;
    public int nVerts;

    public Graph()
    {
        vertices = new Vertex[MAX_VERTS];
        adj_matrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // set adjacency
            for(int k=0; k<MAX_VERTS; k++) // matrix to 0
                adj_matrix[j][k] = 0;
    }




    public boolean addVertex(Character label)
    {
        if (nVerts > MAX_VERTS)
            return false;
        Vertex v = new Vertex(label);
        vertices[nVerts] = v;
        nVerts++;
        return true;
    }

    public void displayVertex(int vertex)
    {
        System.out.print(vertices[vertex].label);
    }

    public void displayAdjMatrix()
    {

        for(int j=0; j<nVerts; j++) // set adjacency
        {
            System.out.print("\n");
            for (int k = 0; k < nVerts; k++) // matrix to 0
                System.out.print(adj_matrix[j][k] + " ");
        }
    }

    public void adddirectedEdge(int start, int end){
        adj_matrix[start][end] = 1;
    }

    public void addEdge(int start, int end){
        adj_matrix[start][end] = 1;
        adj_matrix[end][start] = 1;
    }

    public int getAdjUnvisited(int v)
    {
        for (int i =0; i < MAX_VERTS; i++)
        {
            if(adj_matrix[v][i] == 1 && vertices[i].visited == false)
                return i;
        }
        return -1;
    }

    /*
    It examines the vertex at the top of the stack, using peek().
    It tries to find an unvisited neighbor of this vertex.
    If it doesn’t find one, it pops the stack.
    If it finds such a vertex, it visits that vertex and pushes it onto the stack.
    */

    public void dfs()
    {
        int next_unvisit;
        Stack<Integer> stack = new Stack<>(MAX_VERTS);
        int start = 0;
        System.out.print(vertices[start].label);
        vertices[start].visited = true;
        stack.push(start);
        while(!stack.is_empty()) {
            next_unvisit = getAdjUnvisited(stack.peek());
            if (next_unvisit == -1) {
                if(!stack.is_empty())
                    stack.pop();
            } else {
                vertices[next_unvisit].visited = true;
                System.out.print(vertices[next_unvisit].label + "");
                stack.push(next_unvisit);
            }
        }
    }

}
