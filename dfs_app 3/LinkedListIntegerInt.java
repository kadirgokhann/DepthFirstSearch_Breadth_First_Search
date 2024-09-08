package dfs_app;

public class LinkedListIntegerInt {
    public NodeInt first;
    public NodeInt last;
    
    public LinkedListIntegerInt(){
        first = null;
        last = null;
    } 
    
   public void insertFirst(int x){
       
        NodeInt newNode = new NodeInt(x);
        newNode.next = first;
        first = newNode;
        if(last == null)
            last = newNode;
    }
   


   public void add(int x){
    NodeInt newNode = new NodeInt(x);
       if(last == null){
           first = newNode;
           last = newNode;
       }
       else{
       last.next = newNode;
       last = newNode;
       }
       
   }
   public void addLast(int x){
    NodeInt newNode = new NodeInt(x);
       if(last == null){
           first = newNode;
           last = newNode;
       }
       else{
       last.next = newNode;
       last = newNode;
       }
       
   }
   
   public NodeInt search(int x) {
       NodeInt tmp = first;
       while (tmp.data != x && tmp != null)
           tmp = tmp.next;
       return tmp;
   }

   public int removeFirst() {
        NodeInt firstt = first;
        NodeInt next = first.next;
        if (first == null)
           return -1;
              
        first.next = null;
        first = next;
        return firstt.data;
   }
    public boolean isEmpty() {
        return first == null;
    }
    public NodeInt removeLast(){
        NodeInt tmp    = first;
        NodeInt backUp = last;                                        
        while(tmp.next != last)  //  a - b - c - d - e 
            tmp = tmp.next;
        tmp.next = null;
         last = tmp;
       return backUp; 
    }
}
