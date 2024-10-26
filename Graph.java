import java.util.ArrayList;
import java.util.List;
public class Graph {
    public static void addEdge(List<List<Integer>> adj,int i,int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) {
                System.out.print(j + " "); // Print its adjacent 
            }
            System.out.println(); 
        }
    }
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>(V); 
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);

        System.out.println("printing the Graph ");
         displayAdjList(adj);
    }
}
