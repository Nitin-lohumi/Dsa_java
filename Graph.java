public class Graph {
    public static void addEdge(int[][] arr,int i,int j){
        arr[i][j] = 1;
        arr[j][i] =1;
    }

    public static void Display(int arr[][]){
        for(int[] row:arr){
            for(int val: row){
                System.out.print(val +"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int vertix = 4;
        int [][] mat = new int[vertix][vertix];
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 2, 3);
        System.out.println("printing the Graph ");
        Display(mat);
    }
}
