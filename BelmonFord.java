import java.lang.reflect.Array;
import java.util.Arrays;

class Edge {
    int src;
    int desti;
    int weight;

    Edge(int src, int desti, int weight) {
        this.src = src;
        this.desti = desti;
        this.weight = weight;
    }
}

public class BelmonFord {

    public void belmonFord(int vertices, Edge[] edges, int src) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge v : edges) {
              if(distance[v.src]!=Integer.MAX_VALUE&&distance[v.src]+v.weight<distance[v.desti]){
                 distance[v.desti] = distance[v.src]+v.weight;
              }
            }
        }
        for (Edge v : edges) {
            if(distance[v.src]!=Integer.MAX_VALUE&&distance[v.src]+v.weight<distance[v.desti]){
                System.out.println("negative value cycle founded");
                return;
             }
        }
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t" + (distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]));
        }
    }

    public static void main(String[] args) {
        BelmonFord b = new BelmonFord();
        int vertices = 5;
        Edge[] edges = {
                new Edge(0, 1, -1), new Edge(0, 2, 4),
                new Edge(1, 2, 3), new Edge(1, 3, 2), new Edge(1, 4, 2),
                new Edge(3, 2, 5), new Edge(3, 1, 1), new Edge(4, 3, -3)
        };
        b.belmonFord(vertices, edges, 3);
    }
}
