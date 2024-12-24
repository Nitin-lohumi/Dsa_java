import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class Dsa {
    public static List<String> letterCombinations(String digits) {
        HashMap<String, String> keypad = new HashMap<>();
        keypad.put("2", "abc");
        keypad.put("3", "def");
        keypad.put("4", "ghi");
        keypad.put("5", "jkl");
        keypad.put("6", "mno");
        keypad.put("7", "pqrs");
        keypad.put("8", "tuv");
        keypad.put("9", "wxyz");
        System.out.println("Keypad mapping: " + keypad);
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> group = new ArrayList<>();
        for (String i : digits.split("")) {
            if (keypad.containsKey(i)) {
                group.add(keypad.get(i));
            }
        }
        if (group.isEmpty()) {
            return new ArrayList<>();
        }
        String[] groupArray = group.toArray(new String[0]);

        List<String> result = combine(groupArray);

        return result;
    }

    public static List<String> combine(String[] group) {
       
        if (group.length == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        String firstGroup = group[0];
        List<String> restProduct = combine(slice(group, 1));

        List<String> combinations = new ArrayList<>();
        for (char c : firstGroup.toCharArray()) {
            for (String str : restProduct) {
                combinations.add(c + str);
            }
        }

        return combinations;
    }

    public static String[] slice(String[] array, int start) {
        if (start >= array.length) {
            return new String[0]; 
        }
        String[] result = new String[array.length - start];
        System.arraycopy(array, start, result, 0, array.length - start);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Combinations for 23: " + letterCombinations("23"));
        System.out.println("Combinations for 234: " + letterCombinations("2348"));
        System.out.println("Combinations for empty input: " + letterCombinations(""));
    }
}
