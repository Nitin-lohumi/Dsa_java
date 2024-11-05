import java.util.Collections;
public class ArrayList {
    java.util.ArrayList<String> numbers;
ArrayList(){
     this.numbers = new java.util.ArrayList<String>();
}
public void insert(String data){
    this.numbers.add(data);
}
public void display(){
   for(String str: numbers){
    System.out.println(str);
   }
}
public void delete(String data){
    this.numbers.remove(data);
}
public void Sort(){
     Collections.sort(this.numbers);
}
public static void main(String[] args) {
    ArrayList arr  = new ArrayList();
    arr.insert("nitin");
    arr.insert("shubham");
    arr.insert("nirmal");
    arr.insert("mayank");
    arr.insert("puuja ");
    arr.delete("nitin");
    arr.display();
    arr.Sort();
    System.out.println("printing the sort list of arraylist");
    arr.display();
 }   
}
