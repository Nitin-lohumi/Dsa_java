import java.util.Scanner;
public class Queue {
    public int front;
    public int rare;
    public int size;
    int arr[];
    Queue(int size){
       this.size = size;
       front=-1;
       rare =-1;
       arr = new int[size];
    }
    public void insert(int data){
        if(front==-1 && rare ==-1){
            front++;
            rare++;
            arr[front]=arr[rare]=data;
        }
        else{
            rare ++;
            arr[rare]= data;
        }
    }
    public void delete(){
        if(rare==-1){
            System.out.println("there is no any queue to delete");
        }
        else{
            if(front>rare){
                System.out.println("queue is empty");
            }
            else{
                System.out.println("this element is deleted" + arr[front]);
                 front++;
            }
        }
    }
    public void print(){
        if(rare==-1){
            System.out.println("queue is underflow");
        }
        else{
            if(front>rare){
                 System.out.println("the queue is empty for displying the elements");
            }
            else{
                for(int i=front; i<=rare; i++){
                    System.out.println(arr[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(100);
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
