public class DP {
    public int maxRepeating(String sequence, String word) {
        StringBuilder s = new StringBuilder(word);
        int count = 0;
        while (sequence.contains(s.toString())) {
            count++;
            s.append(word);  // Append the word after counting
        }
        return count;
    }

    public static void main(String[] args) {
        Dp1 d = new Dp1();
        System.out.println(d.maxRepeating("ababc", "ab"));  // Outputs: 2
    }
}
