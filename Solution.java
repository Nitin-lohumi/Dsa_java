class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else {
                if (!isVowel(arr[i])) {
                    i++;
                }
                if (!isVowel(arr[j])) {
                    j--;
                }
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1; 
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("ia"));
        System.out.println(s.reverseVowels("hello")); 
        System.out.println(s.reverseVowels("IceCream"));
    }
}
