
public class Graph_Metrix {
    int metrix[][];
    int n;
    Graph_Metrix(int vertex){
     n =vertex;
    metrix = new int[vertex][vertex];
    }

    public void addEdges(int from,  int to){
        metrix[from][to] = 1;
    }
    public void removeEdges(int from,int to){
        metrix[from][to]=0;
    }
    public void print(){
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.print(metrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph_Metrix gm = new Graph_Metrix(4);

        gm.addEdges(0,2);
        gm.addEdges(2,1);
        gm.addEdges(3,2);
        gm.addEdges(3,1);
        gm.print();
    }
}
