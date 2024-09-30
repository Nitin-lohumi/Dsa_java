public class ArrayList {
    java.util.ArrayList<String> numbers;
ArrayList(){
     this.numbers = new java.util.ArrayList<String>();
}
public void insert(String data){
    this.numbers.add(data);
}
public void display(){
    for (int i = 0; i < this.numbers.size(); i++) {
      System.out.println(this.numbers.get(i));          
    }
}

public static void main(String[] args) {
    ArrayList arr  = new ArrayList();
    arr.insert("nitin");
    arr.insert("shubham");
    arr.insert("nirmal ");
    arr.insert("mayank");
    arr.insert("puuja ");
    arr.display();
 }   
}
