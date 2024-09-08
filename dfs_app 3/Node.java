package dfs_app;

public class Node {
    public Edge data;
    public Node next;
    
    public Node(Edge x){
        this.data = x;
        next = null;
    }
}