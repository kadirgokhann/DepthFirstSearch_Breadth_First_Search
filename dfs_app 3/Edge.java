package dfs_app;

public class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "(" + from + "->" + to + "," + weight + ")";
    }
    
} 
