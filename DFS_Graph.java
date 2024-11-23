import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS_Graph {
    public void Dfs(int startNode, Map<Integer,List<Integer>> graph,Set<Integer> visited,ArrayList<Integer> ans){
    visited.add(startNode);
    ans.add(startNode);
    for (Integer integer : graph.get(startNode)) {
        if(!visited.contains(integer)){
            Dfs(integer, graph, visited,ans);
        }
     }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1));
        graph.put(5, Arrays.asList(2));
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> Ans = new ArrayList<>();
        DFS_Graph df = new DFS_Graph();
        df.Dfs(0, graph, visited, Ans);
        System.out.println(Ans);
    }
}
