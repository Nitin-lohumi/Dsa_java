public class Sorting {
    public static void main(String[] args) {
        int arr [] ={9,7,6,3,4,1};
        //insertion sort

        for(int i=1; i<arr.length; i++){
            int value = arr[i];
            int j = i-1;
            while (j>=0&&value<arr[j]) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] =value;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
    }
}
