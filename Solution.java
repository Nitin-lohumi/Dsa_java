import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            if(set.contains(integer)){
                return true;
            }
            set.add(integer);
        }
    return false;
    }
    public static void main(String[] args) {
        Solution s =new Solution();
       System.out.println(s.containsDuplicate(new int[]{1,1,2,3}));
    }
}