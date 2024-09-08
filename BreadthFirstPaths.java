
package dfs_app;

import java.util.*;

public class BreadthFirstPaths {
    public ArrayList<Integer> path;
    public int source;
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] visited;
    LinkedListIntegerInt queue;
    
    
    public BreadthFirstPaths(ListGraph g, int source)
    {
        this.source = source;
        this.visited = new boolean[g.getNumV()];
        this.queue = new LinkedListIntegerInt();
        this.path = new ArrayList<Integer>();
        this.edgeTo = new int[g.getNumV()];
        this.distTo = new int[g.getNumV()];
        for (int i = 0; i < g.getNumV(); i++)
        {
            this.visited[i] = false;
            this.edgeTo[i]  = -1;
            this.distTo[i]  = -1;
        }

        bfs(g, source);
        System.out.println("BFS Traverse Path:");
        for(int i = 0; i < path.size(); i++)
        {
            System.out.print(path.get(i)  + " ");
        }
        System.out.println("\n");
    }

    public void bfs(ListGraph g, int from) {
        Integer[] arr;
        visited[source] = true;
        queue.add(source);
        while (! queue.isEmpty()) 
        {
            source = queue.removeFirst();
            path.add(source);
            arr    = (Integer[]) g.neighborsArray(source);
            for (int i = 0; i < arr.length; i++) 
            {
                int w = arr[i];
                if (!visited[w])
                {
                    queue.addLast(w);
                    path.add(w);
                    visited[w] = true;                        
                    edgeTo[w]  = source;
                    distTo[w]  = distTo[source] + 1;
                    
                }
            }
        }
    }
    public Stack findPath(int v, int w) //4 
    {  
        int k             = edgeTo[w]; //3 -> 4
        Stack st = new Stack();
        if (k == -1)
        {
            return st;
        }
        st.push(k);
        while (k != this.source) 
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
        return visited[w];
    }
}
