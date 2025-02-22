import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashSet<Integer> array = new HashSet<>();
    for (int number : nums1) {
      map.put(number, number);
    }
    for (int number : nums2) {
      if (map.containsKey(number)) {
        array.add(number);
      }
    }
    return array.stream().mapToInt(Integer::intValue).toArray();
  }
}