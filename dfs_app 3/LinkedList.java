package dfs_app;

public class LinkedList {

    
    public Node first;
    public Node last;
    
    public LinkedList(){
        first = null;
        last = null;
    } 
    
    public void add(Edge x) {
        insertLast(x);
    }
   
   public void insertLast(Edge x){
       Node newNode = new Node(x);
       if(last == null){
           first = newNode;
           last = newNode;
       }
       else{
       last.next = newNode;
       last = newNode;
       }
       
   }


   public void traverse()
   {
       Node tmp = first;
       
       System.out.print("First -> ");
       while (tmp != null)
       {
           System.out.print(tmp.data + " ");
           tmp = tmp.next;
       }
       System.out.println("< - Last");
   }
   
   public Node search(Edge x) {
       Node tmp = first;
       while (tmp.data != x && tmp != null)
           tmp = tmp.next;
       return tmp;
   }
   @Override    
    public String toString() {
         String s = "";
         Node tmp = first;
         while (tmp != null) {
              s += tmp.data + " ";
              tmp = tmp.next;
         }
         return s;
    }

   
}
