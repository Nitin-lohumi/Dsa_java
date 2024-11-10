import java.util.ArrayList;
public class Recursion {
     int fact=0;
     ArrayList<Integer> arr;
    Recursion(){
        this.arr = new ArrayList<Integer>();
        this.arr.add(0);
        this.arr.add(1);
    }
    public void fun(int a,int b,int n){
        if(n==0){
            return;
        }
        int c = a+b;
        arr.add(c);
        fun(b, c, n-1);
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        int a =0;
        int b =1;
        int n =10;
        r.fun(a, b, n);
        System.out.println(r.arr);
    }
}
