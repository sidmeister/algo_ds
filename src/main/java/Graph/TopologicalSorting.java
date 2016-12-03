package Graph;

/**
 * Created by srathi on 11/28/16.
 */
public class TopologicalSorting {



    public static void topo( Graph  graph)
    {
        int current_vertex = 0;
        char[] sortedArray = new char[graph.nVerts];
        int orig_verts = graph.nVerts;
        while(graph.nVerts > 0)
        {
            current_vertex = getNoSuccessors(graph);
            if (current_vertex == -1) //it is a cycle
                return;
            sortedArray[graph.nVerts - 1] = graph.vertices[current_vertex].label;
            deletevertex(graph, current_vertex);
            int i =1;
        }

        // vertices all gone; display sortedArray
        System.out.print("Topologically sorted order: ");
        for(int j=0; j<orig_verts; j++)
            System.out.print( sortedArray[j] );
        System.out.println("");
    } // end topo

    /*

    1) The vertex is removed from the vertexList[] array,
    2) The vertices above it are moved down to fill up the vacant position.
    3) Likewise, the row and column for the vertex are removed from the adjacency matrix,
    and the rows and columns above and to the right are moved down and to the left to fill the vacancies.
    These tasks are carried out by the deleteVertex(), moveRowUp(), and moveColLeft() methods
     */

    public static void deletevertex(Graph graph,int del_vertex)
    {
        for(int j =del_vertex; j < graph.nVerts - 1 ; j++ ) //delete vertex
            graph.vertices[j] = graph.vertices[j+1];
        for(int row=del_vertex; row<graph.nVerts-1; row++) // delete row from adjMat
            moveRowUp(graph,row, graph.nVerts);
        for(int col=del_vertex; col<graph.nVerts-1; col++) // delete col from adjMat
            moveColLeft(graph,col, graph.nVerts-1);
        graph.nVerts--;
    }

    public static void moveRowUp(Graph graph,int row, int length)
    {
        for(int col = 0; col<length; col++) // delete row from adjMat
        {
            graph.adj_matrix[row][col] = graph.adj_matrix[row + 1][col];
        }
    }

    public static void moveColLeft(Graph graph,int col, int length)
    {
        for(int row = 0; row<length; row++) // delete row from adjMat
        {
            graph.adj_matrix[row][col] = graph.adj_matrix[row][col + 1];
        }
    }

    public static int getNoSuccessors(Graph graph)
    {
        boolean is_Edge = false;
        for (int i =0; i <graph.nVerts; i++ )
        {
            is_Edge = false;
            for(int j =0; j <graph.nVerts; j++) {
                if (graph.adj_matrix[i][j] > 0) {
                    is_Edge = true;
                    break;
                }
            }
            if (!is_Edge)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addVertex('F'); // 5
        theGraph.addVertex('G'); // 6
        theGraph.addVertex('H'); // 7
        theGraph.adddirectedEdge(0, 3); // AD
        theGraph.adddirectedEdge(0, 4); // AE
        theGraph.adddirectedEdge(1, 4); // BE
        theGraph.adddirectedEdge(2, 5); // CF
        theGraph.adddirectedEdge(3, 6); // DG
        theGraph.adddirectedEdge(4, 6); // EG
        theGraph.adddirectedEdge(5, 7); // FH
        theGraph.adddirectedEdge(6, 7); // GH
        topo(theGraph);
    }
}
