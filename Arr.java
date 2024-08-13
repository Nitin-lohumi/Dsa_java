import java.util.Arrays;
class Solution {
    public int[] productExceptSelf(int[] nums) {
       int answer[]= new int[nums.length];
       int product =1;
       Arrays.fill(answer,1);
       for(int i =0; i<nums.length; i++){
           answer[i] = product*answer[i];
           product = product*nums[i];
       }
       product =1;
       for(int i=nums.length-1; i>=0; i--){
            answer[i] = product*answer[i];
            product = product*nums[i];
       }
       return answer;
    }
}
public class Arr {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr ={1,2,3,4};
        int[] answer = s.productExceptSelf(arr);
        for (int i = 0; i < answer.length; i++) {
             System.out.println(answer[i]);
        }
    }
}