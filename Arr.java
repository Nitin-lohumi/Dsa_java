class Arr {
		public int maxProfit(int[] prices) {
			int profit =0;
			int store = prices[0];
			for(int i=0; i<prices.length-1; i++){
			if(store<prices[i+1]){
             profit  = profit + prices[i+1]- store;
			 store = prices[i+1];
			}
			else{
				store = prices[i+1];
			}
			}
			return profit;
		}
	    public static void main(String[] args) {
		int [] prices  = {1,2,3,4,5};
		Arr a = new Arr();
		System.out.println("total profit + " + a.maxProfit(prices));
	}
}