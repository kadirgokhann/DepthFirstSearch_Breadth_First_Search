
package dfs_app;
import java.util.*;
 
public class DepthFirstPaths {
    public ArrayList<Integer> path;
    public int                source;
    public boolean[]          marked;
    public int[]              edgeTo;
    
    public DepthFirstPaths(ListGraph g,int source)
    {
        this.source = source;
        this.marked = new boolean[g.getNumV()];
        this.edgeTo = new int[g.getNumV()];
        this.path = new ArrayList<Integer>();
        for (int i = 0; i < g.getNumV(); i++)
            this.edgeTo[i] = -1;
        dfs(g, source);
        System.out.println("DFS Traverse Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println("\n");
    }
    
    public void dfs(ListGraph g, int from){ 
        marked[from] = true;
        path.add(from);
        Integer[] numOfNeighbors;
        numOfNeighbors =(Integer[])g.neighborsArray(from);
        for(int i = 0; i < numOfNeighbors.length; i++)
        {
            int neighbor = numOfNeighbors[i]; 
            if(marked[neighbor] == false) 
            {
                dfs(g, neighbor);
                edgeTo[neighbor] = from;  
            }
        }
    } 
        
    public Stack findPath(int u, int w) //4 
    {  
        int k    = edgeTo[w]; //3 -> 4
        Stack st = new Stack();
        if (k == -1)
        {
            return st;
        }
        st.push(k);
        while (k != u) 
        {
            if (k == -1)
            {
                return new Stack();
            }
            k = edgeTo[k];
            if (k == -1)
            {
                return st;
            }
            st.push(k);
        }
        return st;
    }
    
    public boolean hasPathTo(int w)
    {
        return marked[w];
    }
}
