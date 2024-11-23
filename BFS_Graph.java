import java.util.*;
import java.util.Queue;
public class BFS_Graph {
    
     public void Bfs(int startNode,Map<Integer,List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        Set<Integer> visit = new HashSet<>();
        visit.add(startNode);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.print(currNode + " ");
            for (int integer : graph.get(currNode)) {
                if(!visit.contains(integer)){
                 queue.add(integer);
                 visit.add(integer);
                }
            }
        }
     }
    public static void main(String[] args) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));
        graph.put(5, Arrays.asList(2));
        BFS_Graph bf= new BFS_Graph();
        bf.Bfs(0, graph);
    }
}
