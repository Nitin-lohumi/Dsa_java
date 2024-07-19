import java.util.*;
public class LinkedList1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(); 
        list.add("helo"); 
        list.add("my");
        list.add("name");
        list.add("nitin");
        System.out.println("linked list " + list);
        list.removeFirst();
        System.out.println("after removing frist" + list);
        list.clear();  
        System.out.println("LinkedList after clearing:"+list);  
    }
}
