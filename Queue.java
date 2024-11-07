import java.util.Scanner;
import java.util.ArrayList;
public class Queue {
    public int front;
    public int rare;
    public int size;
    private int mainSize;
    public ArrayList<Integer> queue;
    public Queue(int size){
       this.queue=new ArrayList<>();
       this.size = size;
       front=-1;
       rare =-1;
       mainSize=-1;
    }
    public void insert(int data){
        if(mainSize==size){
             System.out.println("fullll");
             return;
        }
        rare = (rare+1)%this.size;
        queue.add(rare, data);
        mainSize++;
        System.out.println("inserted");
    }
    public void delete(){
        if(rare==-1){
            System.out.println("there is no any queue to delete");
        }
        else{
                System.out.println("this element is deleted");
                front = (front+1)%this.size;
                mainSize--;
                System.out.println("deleted");
        }
    }
    public void print(){
        int i = front;
        if(rare==-1){
            System.out.println("queue is underflow");
        }
        else{
            if(front>rare){
                 System.out.println("the queue is empty for displying the elements");
            }
            else{
               while(i<=mainSize){
                System.out.print(queue.get(i));
                i++;
               }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(10);
         Scanner s = new Scanner(System.in);
     int choice;
    do{
      System.out.println(" 1 - insert , 2 - delete , 3 - display");
      choice = s.nextInt();
      switch (choice) {
       case 1:
          int data = s.nextInt();
          q.insert(data);
          break;
       case 2:
           q.delete();
           break;
       case 3:
           q.print();
           break;
      }
    }while(choice!=0);
      s.close();
    }
}
