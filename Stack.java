import java.util.*;
public class Stack {
   int top ;
   public int arr [];
   int capacity;
   Stack(int size){
    arr = new int[size];
    capacity = size;
    top =-1;
   }
   public void push(int element){
    if(isfull()){
        System.out.println("stack overflow");
    }
   else{
    top++;
    arr[top] = element;
    System.out.println("inserted");
   }
   }
   public void pop(){
    if(isfull()){
      System.out.println("overflow or under flow");
    }
    else{
      top = top-1;
    }
   }
   void display(){
    if(top==-1){
      System.out.println("underflow");
    }
    else{
      for(int i=0; i<=top; i++){
        System.out.println(arr[i]);
      }
    }
   }
   public boolean isfull(){
    return top == capacity-1;
   }
   public static void main(String[] args) {
    Stack sc = new Stack(10);
     Scanner s = new Scanner(System.in);
     int choice;
    do{
      System.out.println(" 1 - push , 2 - pop , 3 - display");
      choice = s.nextInt();
      switch (choice) {
       case 1:
          int data = s.nextInt();
          sc.push(data);
          break;
       case 2:
           sc.pop();
           break;
       case 3:
           sc.display();
           break;
      }
    }while(choice!=0);
  s.close();
   }
}
