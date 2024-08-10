class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Queue{
	Node front;
	Node rare;
	Queue(){
      this.front= null;
	  this.rare = null;
	}
	void insert(int data){
    Node newnode  = new Node(data);
    if(this.front==null||this.rare==null){
		this.front=this.rare=newnode;
	}
	else{
		this.rare.next = newnode;
		this.rare = newnode;
		this.rare.next = this.front;
	}
	}
	int remove(){
		if(this.front==null||this.rare==null){
			return 0;
		}
		else{
		int data = this.front.data;
         this.front  = this.front.next;
		 this.rare.next = this.front;
		 return data;
		}	
	}
	void display(){
		if(this.front==null||this.rare==null){
			System.out.println("no element to print");
		}else{
           Node temp = this.front;
		   while (temp.next!=this.front) {
			System.out.println(temp.data);
			temp = temp.next;
		   }
		   System.out.println(temp.data);
		}
	}
}
public class Arr {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.insert(10);
		q.insert(20);
		q.insert(30);
		q.insert(40);
		q.insert(50);
		q.remove();
		q.display();
	}
}