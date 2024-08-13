class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
      this.prev =null;
      this.data = data;
      this.next = null;
    }
}
class CircularLinkList{
    Node head;
    CircularLinkList(){
      this.head=null;
    }
    public void insert(int data){
     Node newnode = new Node(data);
     if(this.head==null){
        this.head = newnode;
        newnode.next = newnode;
        newnode.prev = newnode;
     }
     else{
        Node temp = this.head;
        while(temp.next!=this.head){
            temp = temp.next;
        }
        temp.next = newnode ;
        newnode.next= this.head;
        newnode.prev = temp;
     }
     System.out.println("inserted");
    }
    public void remove(int data){
       if(this.head==null){
        System.out.println("null");
       }
     else{ Node temp = this.head;
       while(temp.next!=this.head){
          if(temp.data==data){
           break;
          }
          temp = temp.next;
       }
       temp.prev.next = temp.next;
       temp.next.prev = temp.prev;
       temp =null;}
    }
    public void display(){
        Node temp = this.head; 
        while(temp.next!=this.head){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
public class LinkedList1 {
    public static void main(String[] args) {
        CircularLinkList cl = new CircularLinkList();
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        cl.insert(40);
        cl.remove(40);
        cl.display();
    }

}