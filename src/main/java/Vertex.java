/**
 * Created by srathi on 11/20/16.
 */
public class Vertex {

    Character label;
    Boolean visited;

    public Vertex()
    {
        visited = false;
    }

    public Vertex(Character label)
    {
        this.label = label;
        visited = false;
    }
}
