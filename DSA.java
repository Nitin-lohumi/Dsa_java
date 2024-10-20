class DSA {
   public int singleNumber(int[] nums) {
     int number =0;
     for(int i =0; i<nums.length; i++){
      number=number^nums[i];
     }
      return number;
   }
   public static void main(String[] args) {
      DSA a = new DSA();
      int arr[]= {3,1,1,2,2};
      System.out.println(a.singleNumber(arr));
   }
}