package dfs_app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListGraph {
    private HashTable ht;
    private LinkedList[] edges;
    private int[] inDegrees;
    private int[] outDegrees;
    private int numV;
    private int numE;

    public ListGraph(int V) 
    {
        this.numV       = V;
        this.numE       = 0;
        this.ht         = new HashTable(V);
        this.edges      = new LinkedList[V];
        this.inDegrees  = new int[V];
        this.outDegrees = new int[V];

        for (int i = 0; i < V; i++) {
            edges[i]      = new LinkedList();
            inDegrees[i]  = 0;
            outDegrees[i] = 0;
        }
    }

    public boolean IsDirected()
    {
        return true;
    }

    public int whatIsShortestPathLength(String v1, String v2){
        return 0;
    }

    public int numberOfSimplePaths(String v1, String v2) {
        return 0;
    }

    public boolean isThereACycle(String v1) {
        return false;
    }

    public int numberOfVerticesInComponent(String v1) {
        ConnectedComponents cc = new ConnectedComponents(this);
        return cc.count;
    }

    public void addEdge(int from, int to, int weight) {
        if (from >= 0 && to >= 0 && to < numV ) {
            edges[from].add(new Edge(from, to, weight));
            numE++;
        } else {
            System.out.println("Vertex out of bounds!");
        }
    }
    
    public static ListGraph readGraphFromFile(String fileName) throws FileNotFoundException {
        ListGraph cityGraph = new ListGraph(ListGraph.numOfVertices(fileName));
       
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(" -> "); //["G", "H: 2, I: 1, K: 5"]
                String from = parts[0]; // "G"
                String[] dests = parts[1].split(", "); // ["H: 2", "I: 1", "K: 5"]
                int fromIndex = cityGraph.ht.insert(from);
                for (String dest : dests) {
                    cityGraph.numE++;
                    String[] parts2 = dest.split(": "); // ["H", "2"]
                    String to = parts2[0];
                    int weight = Integer.parseInt(parts2[1]);
                    int toIndex = cityGraph.ht.insert(to);
                    cityGraph.addEdge(fromIndex, toIndex, weight);
                    cityGraph.outDegrees[fromIndex]++;
                    cityGraph.inDegrees[toIndex]++;
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityGraph;
    }

    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append("G(" + numV + "," + numE + ") \n");
        for (int i = 0; i < numV; i++) {
            sb.append(i + " " + edges[i].toString() + "\n");
        }

        return sb.toString();
    }

    public int inDegree(int from) {
        return inDegrees[from];
    }
    public int outDegree(int from) {
        return outDegrees[from];
    } 

    public String highestDegree() {
        // Return the name(s) of the vertex with the highest degree
        int max = 0;
        int ith = 0;
        for (int i = 0; i < numV; i++) {
            int degree = inDegrees[i] + outDegrees[i];
            if (degree > max) {
                max = degree;
                ith = i;
            }
        }
        return ht.table[ith];
    }
    
    public ArrayList<String> Neighbors(String from) {
        ArrayList<String> list = new ArrayList<>();
        int index = ht.getIndexOf(from);
        LinkedList edgeList = edges[index];
   
        Node tmp = edgeList.first;
        while (tmp != null)
        {
            list.add(ht.table[tmp.data.to]);
            tmp = tmp.next;
        }

        return list;
    }

    public ArrayList<String> neighborsList(String from) {
        ArrayList<String> list = new ArrayList<>();
        int index = ht.getIndexOf(from);
        LinkedList edgeList = edges[index];

        Node tmp = edgeList.first;
        while (tmp != null)
        {
            list.add(ht.table[tmp.data.to]);
            tmp = tmp.next;
        }
        return list;
    }
    
    public ArrayList<Integer> neighborsList(int from) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList edgeList = edges[from];

        Node tmp = edgeList.first;
        while (tmp != null)
        {
            list.add(tmp.data.to);
            tmp = tmp.next;
        }
        return list;
    }

    public String[] neighborsArray(String from) {
        ArrayList<String> list = new ArrayList<>();
        int index = ht.getIndexOf(from);
        LinkedList edgeList = edges[index];

        Node tmp = edgeList.first;
        while (tmp != null)
        {
            list.add(ht.table[tmp.data.to]);
            tmp = tmp.next;
        }
        String[] arr = new String[list.size()];
        return list.toArray(arr);
    }
    public Integer[] neighborsArray(int from) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList edgeList = edges[from];
        Node tmp = edgeList.first;
        while (tmp != null)
        {
            list.add(tmp.data.to);
            tmp = tmp.next;
        }
        Integer[] arr = new Integer[list.size()];
        return list.toArray(arr);
    }
    
    public void DFSfromTo(String v1, String v2) {
        // Implement depth-first search (DFS) from v1 to v2
        DepthFirstPaths obje = new DepthFirstPaths(this, ht.getIndexOf(v1));
        Stack st    = obje.findPath(ht.getIndexOf(v1), ht.getIndexOf(v2));
        Stack st2   = obje.findPath(ht.getIndexOf(v1), ht.getIndexOf(v2));
        System.out.println("DFS Path( " + v1 + " to " + v2 + ")");
        while (!st.isEmpty()) {
            System.out.print(ht.table[st.pop()] + " ");
        }
        System.out.println("\n");
        System.out.println("DFS Path( " + v1 + " to " + v2 + ")");
        while (!st2.isEmpty()) {
            System.out.print(st2.pop() + " ");
        }
        System.out.println("\n");

    }
    
    public void DFSfromTo(int v1, int v2) {
        DepthFirstPaths obje = new DepthFirstPaths(this, v1);
        Stack st    = obje.findPath(v1,v2);
        Stack st2   = obje.findPath(v1,v2);
        System.out.println("DFS Path( "+ v1 + " to " + v2 + ")");
        while (!st2.isEmpty()) {
            System.out.print(st2.pop() + " ");
        }
        System.out.println("\n");
        System.out.println("DFS Path( "+ ht.table[v1] + " to " + ht.table[v2] + ")");
        while (!st.isEmpty()) {
            System.out.print(ht.table[st.pop()] + " ");
        }
        System.out.println("\n");

    }

    public void printAdjancencyMatrix()
    {
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                if (areTheyAdjacent(i, j)) {
                    LinkedList list = edges[i];
                    int w = 0;
                    Node tmp = list.first;
                    while (tmp != null)
                    {
                        if (tmp.data.to == j) {
                            w = tmp.data.weight;
                        }
                        tmp = tmp.next;
                    }
                    System.out.print(w + ", ");
                } else {
                    System.out.print("0, ");
                }
            }
            System.out.println("");
        }
    }

    public void printHt()
    {
        ht.print();
    }

    public void BFSfromTo(int v1, int v2) {
        BreadthFirstPaths obje = new BreadthFirstPaths(this, v1);
        Stack st = obje.findPath(v1, v2);
        Stack st2 = obje.findPath(v1, v2);
        System.out.println("BFS Path( "+ v1 + " to " + v2 + "):");
        while (!st2.isEmpty()) {
            System.out.print(st2.pop() + " ");
        }
        System.out.println("\n");
        System.out.println("BFS Path( "+ ht.table[v1] + " to " + ht.table[v2] + ")");
        while (!st.isEmpty()) {
            System.out.print(ht.table[st.pop()] + " ");
        }
        System.out.println("\n");
    }

    public void BFSfromTo(String v1, String v2) {
        BreadthFirstPaths obje = new BreadthFirstPaths(this, ht.getIndexOf(v1));
        Stack st = obje.findPath(ht.getIndexOf(v1), ht.getIndexOf(v2));
        Stack st2 = obje.findPath(ht.getIndexOf(v1), ht.getIndexOf(v2));
        System.out.println("BFS Path( "+ v1 + " to " + v2 + "):");
        while (!st2.isEmpty()) {
            System.out.print(st2.pop() + " ");
        }
        System.out.println("\n");
         System.out.println("BFS Path( "+ v1 + " to " + v2 + ")");
        while (!st.isEmpty()) {
            System.out.print(ht.table[st.pop()] + " ");
        }
        System.out.println("\n");
    }

    public static int numOfVertices(String fileName) throws FileNotFoundException {
        ArrayList<String> set = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" -> ");
                String from = parts[0];
                if (!set.contains(from))
                    set.add(from);
                String[] dests = parts[1].split(", ");

                for (String dest : dests) {
                    String[] parts2 = dest.split(": ");
                    if (!set.contains(parts2[0]))
                        set.add(parts2[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set.size();
    }

    public ArrayList<String> neighbors(String v1) {
        // Return the names of the neighbor vertices of v1
        int i = ht.getIndexOf(v1);
        LinkedList list = edges[i];
        ArrayList<String> arr = new ArrayList<>();
        Node tmp = list.first;
        while (tmp != null) {
            arr.add(ht.table[tmp.data.to]);
            tmp = tmp.next;
        }

        return arr;
    }
    public boolean areTheyAdjacent(String from, String to) {
        int ind_from  = ht.getIndexOf(from);
        int ind_to = ht.getIndexOf(to);
        LinkedList list = edges[ind_from];

        Node tmp = list.first;
        while (tmp != null) {
            if (tmp.data.to == ind_to) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    public boolean areTheyAdjacent(int from, int to) {
        LinkedList list = edges[from];

        Node tmp = list.first;
        while (tmp != null) {
            if (tmp.data.to == to) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }
    
    public boolean isThereAPath(String v1, String v2) {
        // Implement depth-first search (DFS) from v1 to v2
        DepthFirstPaths obje = new DepthFirstPaths(this, ht.getIndexOf(v1));
        Stack st = obje.findPath(ht.getIndexOf(v1), ht.getIndexOf(v2));
        int i = 0;
        while (!st.isEmpty()) {
            st.pop();
            i++;
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean isThereAPath(int v1, int v2) {
        // Implement depth-first search (DFS) from v1 to v2
        DepthFirstPaths obje = new DepthFirstPaths(this, v1);
        Stack st  = obje.findPath(v1, v2);
        int i = 0;
        while (!st.isEmpty()) {
            st.pop();
            i++;
        }
        return i > 0;
    }
}
