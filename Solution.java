class Solution {
    public boolean divisorGame(int n) {
        boolean alice =false;
        int x =0;
        return game(n,alice,x);
    }

    private boolean game(int n, boolean alice,int x){
       if(x>n||x<0){
        return false;
       }
       return x>n?game(n, alice, x-1):game(n, alice, x+1);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divisorGame(2));
    }
}
