import java.util.ArrayList;

public class HeapBubbleUp {

    ArrayList<Integer> heap;

    HeapBubbleUp(int cap){
     heap = new ArrayList<>();
    } 

    public void swap(int a, int b){
        int temp = heap.get(a);
        heap.set(a,heap.get(b));
        heap.set(b,temp);
    }

    public void insert(int data){
     heap.add(data);
     int curr = heap.size()-1;
     while(curr>0){
       int parent = (curr-1)/2;
       if(heap.get(curr)<heap.get(parent)){
           swap(curr, parent);
           curr = parent;
       }else{
        break;
       }
     }
    }
    
    public void printHeap(){
        for (Integer integer : heap) {
              System.out.print(" "+integer);
        }
    }
    public static void main(String[] args) {
        HeapBubbleUp hp = new HeapBubbleUp(100);
        hp.insert(10);
        hp.insert(20);
        hp.insert(50);
        hp.insert(60);
        hp.insert(80);
        hp.insert(90);
        hp.printHeap();

    }
}
