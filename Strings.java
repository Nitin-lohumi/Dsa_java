import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        sb.append("h");
        sb.append("h");
        sb.append("h");
        sb.append("h");
        sb.append(1079);
        sb.insert(0, "nitin is here ");
        sb.replace(13, sb.length(), " this is replace");
       
        String name= "nitin lohumi ";
        // String name1 = "lohumi";
        String[] join = name.split("i");
        String change = String.join("-",join);
        System.out.println(join.getClass().getSimpleName());
        System.out.println(change.getClass().getSimpleName());
        System.out.println(change);


    }
}
