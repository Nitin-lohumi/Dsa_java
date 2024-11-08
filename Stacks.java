import java.util.Stack;
public class Stacks<T>{
   Stack<T> st;
   int size;
   Stacks(){
   st= new Stack<T>();
   }
   public void insert(T data){
    st.push(data);
   }
   public T poping(){
    if(st.empty()){
      System.out.println("Empty stacks");
      return null;
    }
    T element  = st.pop();
    return element;
   }
   public void  display(){
    if(st.isEmpty()){
      System.out.println("Empty elemnts in stacks ");
    }
    System.out.println(st);
   }
   public int  searchElements(T search){
     return st.search(search);
   }
  public static void main(String[] args) {
    Stacks<String>s = new Stacks<>();
    s.insert("nitin");
    s.insert("shubham");
    s.insert("nirmal");
    s.insert("mayank");
    s.poping();
    s.display();
    System.out.println(s.searchElements("sbubham"));
    System.out.println(s.st.size());
  }
}