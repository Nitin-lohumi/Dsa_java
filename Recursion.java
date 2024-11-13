public class Recursion {
     int frist=-1;
     int last=-1;
    public void fun(String source,int i, char ch) {
       if(i<0){
        System.out.println(frist +" is in frist occourence ");
        System.out.println(last +" is in last occourence ");
        return;
       }
       if(source.charAt(i)==ch){
       if(this.last==-1){
            this.last = i;
          }else{
            this.frist  = i;
          }
       }
       fun(source,i-1,ch);
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        r.fun("abcddddaaah",10,'a');

    }
}
