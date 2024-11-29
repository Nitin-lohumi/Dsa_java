import java.util.*;
import java.util.Queue;
import java.util.ArrayList;

public class Graph_adjencyList {
    private Map<Integer, List<Integer>> adjList;
    public Graph_adjencyList() {
        adjList = new HashMap<>();
    }
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<>());
    }
    public void addEdges(int from, int to) {
        adjList.putIfAbsent(to,new LinkedList<>());
        adjList.putIfAbsent(from, new LinkedList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from);
    }
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    public void DFS(int startPoint,Set<Integer> visited,Map<Integer,List<Integer>> graph,ArrayList<Integer> ans){
      visited.add(startPoint);
      ans.add(startPoint);
    //   for (Integer vertex : graph.get(startPoint)) {
    //     if(!visited.contains(vertex)){
    //         DFS(vertex, visited, graph, ans);
    //     }
    //   }
    for (List<Integer> vertex : graph.values()) {
        for (Integer integer: vertex) {
            if(!visited.contains(integer)){
                ans.add(integer);
                visited.add(integer);
            }
        }
    }
    }
    public void BFS(int key,Set<Integer> visited,Map<Integer,List<Integer>> map,ArrayList<Integer> AnsList){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        visited.add(key);
        while (!queue.isEmpty()) {
            int retive = queue.poll();
            AnsList.add(retive);
            for (Integer element : map.get(retive)) {
                if(!visited.contains(element)){
                    visited.add(element);
                    queue.add(element);
                }
            }
        }
    }
    public void removeVertex(int vertex){
        adjList.remove(vertex);
        for (List<Integer> element :adjList.values()) {
            element.remove(Integer.valueOf(vertex));
        }
    }
    public void removeEdge(int from , int to){
        List<Integer> element = adjList.get(from);
        List<Integer> element1 = adjList.get(to);
        if(element1!=null){
            element1.remove(Integer.valueOf(from));
        }
        if(element!=null){
            element.remove(Integer.valueOf(to));
        }
    }
    public static void main(String[] args) {
        Graph_adjencyList gp = new Graph_adjencyList();
        ArrayList<Integer> answer =new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        gp.addVertex(10);
        gp.addVertex(3);
        gp.addVertex(5);
        gp.addVertex(7);
        gp.addEdges(10, 3);
        gp.addEdges(3, 5);
        gp.addEdges(7, 10);
        gp.addEdges(5, 7);
        System.out.println("printing the Graph ");
        gp.printGraph();
        // gp.BFS(10,visit,gp.adjList,answer);
        gp.DFS(10,visit,gp.adjList,answer);
        System.out.println(answer);
        // gp.removeVertex(10);
        gp.removeEdge(10,7);
        System.out.println("after delete the vertex ");
        gp.printGraph();
    }
}
