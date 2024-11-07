import java.util.Scanner;
public class StarPrinting {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//5
        char num='a';
        for (int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++){
             System.out.print(" ");
            }
            for(int j=0; j<(2*i)-1; j++){
                if((j==0)||i==n-1||j==2*i-2){
                    System.out.print(num);
                    num++;
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
