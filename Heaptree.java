public  class Heaptree {
    int [] heap;
    int size;
    int sortlen;
    
    Heaptree(int []arr){
      this.size =arr.length;
      sortlen = arr.length;
      heap =arr;
      buildHeap();
    }

    public int parent(int index){
        return(index-1)/2;
    }
    public int leftChild(int index){
        return 2*index+1;
    }
    public int Rightchild(int index){
        return 2*index+2;
    } 

    public void swap(int i ,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public void heapify(int index){
        int parent = index;
        int left = leftChild(index);
        int right = Rightchild(index);

        if(left<size&& heap[left]<heap[parent]){
            parent = left;
        }
        if(right<size&&heap[right]<heap[parent]){
            parent = right;
        }
        if(parent!=index){
            swap(index,parent);
            heapify(parent);
        }
    }
    public void buildHeap(){
        for (int i = size/2-1; i >=0; i--) {
            heapify(i);
        }
    }

    public void Delete(){
        if(size<=0){
            System.out.println("no element to be deleted");
            return;
        }
        swap(0, size-1);
        size--;
        System.out.println("elements is deleted");
        buildHeap();
    }


    public void heapsort(){
        if(size==0){
           for (int i = 0; i <sortlen; i++) {
              System.out.print(" "+heap[i]);
           }
        }
    }
    public static void main(String[] args) {
    int[] arr = {10, 20, 15, 30, 40, 50, 25};
    Heaptree ht = new Heaptree(arr);
    ht.printHeap();
    ht.heapsort();
}
}