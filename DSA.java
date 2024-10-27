import java.util.*;
public class Dsa{
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");
        for (HashMap.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println("key:" +entry.getKey()+"  "+"value" +entry.getValue());
        }
    }
}