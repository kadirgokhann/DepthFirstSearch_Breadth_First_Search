package dfs_app;

public class Stack {
    private LinkedListIntegerInt myLinkedList;
    private NodeInt top;
    
    public Stack(){
        this.myLinkedList = new LinkedListIntegerInt();
        top = null;
    }          
     public void push(int x){
         myLinkedList.addLast(x);
         this.top = myLinkedList.last;
    }
    public int pop(){
        return(myLinkedList.removeLast().data);
    }
    
    public boolean isEmpty(){
        return(myLinkedList.isEmpty());
    }
}

