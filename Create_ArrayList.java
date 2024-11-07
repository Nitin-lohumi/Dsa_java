import java.util.ArrayList;

public class Create_ArrayList {
    public static void main(String[] args) throws Exception {
       ArrayList<Integer> arr = new ArrayList<Integer>(10);
       System.out.println(arr.size());
       arr.add(0,1);
       arr.set(0,100);
       arr.remove(arr.get(0));
      try {
        System.out.println(arr.get(0));
        System.out.println(arr);
        System.out.println(arr.contains(arr.get(0)));
      } catch (Exception e) {
        throw new Exception("this code going for out of  bounded ");
      }
    }
}