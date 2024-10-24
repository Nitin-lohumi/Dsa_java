import java.util.ArrayList;
import java.util.Collections;
public class Dsa{
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<String>();
        name.add("nitin");
        name.add("shubham");
        name.add("nirmal");
        name.add("puja");
        name.add("mayank");
        Collections.emptyList();
        for (String string : name) {
            System.out.println(string);
        }
    }
}