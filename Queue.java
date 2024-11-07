import java.util.Scanner;
import java.util.LinkedList;
public class Queue<T> {
  LinkedList<T> list;
  int maxSize;
    Queue(int maxSize) {
      list= new LinkedList<>();
      this.maxSize = maxSize;
    }

  public void insert(T data) {
   if(list.size()>=maxSize){
    System.out.println("Queue is full. Dequeuing the oldest element to make space...");
    list.poll();
   }
   list.offer(data);
   System.out.println("inserted"  );
  }

  public void delete() {
    if (list.isEmpty()) {
      System.out.println("there are no any elements to delete ");
    }
   else{
    T item =  list.poll();
    System.out.println( " the deleted elements is "+ item);
   }
  }

  public void print() {
     System.out.println("Queue" + list);
  }

  public static void main(String[] args) {
    Queue<Integer> q = new Queue<>(100);
    Scanner s = new Scanner(System.in);
    int choice;
    do {
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
    } while (choice != 0);
    s.close();
  }
}
