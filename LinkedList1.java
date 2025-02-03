import java.util.LinkedList;
import java.util.List;

public class LinkedList1<T>{
   LinkedList <T> list;
   int cap; 
   LinkedList1(int cap){
    this.list = new LinkedList<T>();
    this.cap = cap;
   }
   public void insert( T data){
    list.add(data);
   }
   public void insertFrist(T data){
    list.addFirst(data);
   }
   public void insertlast(T data){
    list.addLast(data);
   }
   public void insertspecific(int index,T data){
    list.add(index, data);
   }
   public T deletespecfic(int index)
   {
   return  list.remove(index);
   }
   public T deleteFrist(){
    return list.removeFirst();
   }
   public T deleteLast(){
    return list.removeLast();

   }
   public void display(){
    if(list.isEmpty()){
        System.out.println("empty list..");
        return;
    }
    for (T t : list) {
       System.out.print(" "+ t +"->");   
    }
    System.out.print(" null");
   }
    public void reorderList(List<Integer> head) {
     
    }

   public static void main(String[] args) {
    LinkedList1<Integer> list = new LinkedList1<>(100);
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);
   //  list.deletespecfic(2);
   //  list.insertspecific(3, 1000);
   //  list.insertFrist(00);
   //  list.insertlast(2000);
    list.display();
   }
}