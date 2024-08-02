public class Array {
    public static void getCumulativeSum (int[] arr) {
		int prefixSum[] = new int[arr.length];
			for(int i = 0; i < arr.length; i++) {
				int prefix = 0;
				for(int j = 0; j <= i; j++) {
					prefix += arr[j];
				}
				prefixSum[i] = prefix;
			}
		for(int i=0; i<prefixSum.length; i++){
			System.out.println(prefixSum[i]);
		}
	}
    public static void main(String[] args) {
		int [] arr = {1,2,3,4};
	    getCumulativeSum(arr);
    }
}
