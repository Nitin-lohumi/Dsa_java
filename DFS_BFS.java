import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Deque;
// class Solution {
//     private ArrayList<ArrayList<Pair>> adjList;

//     // Pair class to store the neighbor and weight
//     static class Pair {
//         int vertex;
//         int weight;
//         Pair(int vertex, int weight) {
//             this.vertex = vertex;
//             this.weight = weight;
//         }
//     }

//     // Constructor
//     public Solution(int n) {
//         adjList = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>()); // Initialize adjacency list for each vertex
//         }
//     }

//     // Add an edge (u, v, weight)
//     public void addEdge(int u, int v, int weight) {
//         adjList.get(u).add(new Pair(v, weight)); // Add v to u's list
//         // adjList.get(v).add(new Pair(u, weight)); // Add u to v's list (for undirected graph)
//     }

//     // Print adjacency list
//     public void printGraph() {
//         for (int i = 0; i < adjList.size(); i++) {
//             System.out.print("Vertex " + i + ":");
//             for (Pair neighbor : adjList.get(i)) {
//                 System.out.print(" (" + neighbor.vertex + ", " + neighbor.weight + ") ,");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Solution graph = new Solution(5);

//         // Add weighted edges
//         graph.addEdge(0, 1, 10);
//         graph.addEdge(0, 4, 20);
//         graph.addEdge(1, 2, 30);
//         graph.addEdge(1, 3, 40);
//         graph.addEdge(1, 4, 50);
//         graph.addEdge(3, 4, 60);

//         // Print graph
//         graph.printGraph();
//     }
// }

public class DFS_BFS {
    private Map<String, ArrayList<String>> adjList;

    public DFS_BFS() {
        adjList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String u, String v) {
        adjList.get(u).add(v); // Add v to u's list
        // adjList.get(v).add(u); // Add u to v's list (for undirected graph)
    }

    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ":");
            for (String neighbor : adjList.keySet()) {
                System.out.print(neighbor);
            }
            System.out.println();
        }
    }

    public void Dfs(Map<String, Boolean> visited, String vertex) {
        visited.put(vertex, true);
        System.out.println(" " + vertex);
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.containsKey(neighbor)) {
                Dfs(visited, neighbor);
            }
        }
    }

    public void Bfs(Map<String, Boolean> visited, String vertex) {
        Deque<String> queue = new ArrayDeque<>();
        visited.put(vertex, true);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            String arr = queue.poll();
            System.out.println("  " + arr);
            for (String string : adjList.get(arr)) {
                if (!visited.containsKey(string)) {
                    visited.put(string, true);
                    queue.add(string);
                }
            }
        }
    }

    public int CountConnectedNode() {
        HashSet<String> visited = new HashSet<String>();
        Deque<String> deque = new ArrayDeque<>();
        deque.add("C");
        visited.add("C");
        int countNode = 1;
        while (!deque.isEmpty()) {
            String str = deque.poll();
            for (String string : adjList.get(str)) {
                if (!visited.contains(string)) {
                    countNode = countNode + 1;
                    visited.add(string);
                    deque.add(string);
                }
            }
        }
        return countNode;
    }

    public int CountConnectedNodeDFs(Map<String, Boolean> visited, String vertex) {
        visited.put(vertex, true);
        int count = 1;
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.getOrDefault(neighbor, false)) {
                count = count + CountConnectedNodeDFs(visited, neighbor);
            }
        }
        return count;
    }

    public boolean HasCycle() {
        HashSet<String> set = new HashSet<>();
        for (String node : adjList.keySet()) {
            if (!set.contains(node)) {
                if (cycleDetect(node, "", set))
                    return true;
            }
        }
        return false;
    }
    boolean cycleDetect(String node, String parent, HashSet<String> set) {
        set.add(node);
        for(String neighbor:adjList.get(node)){
              if(!set.contains(neighbor)){
                if(cycleDetect(neighbor,node, set)) return true;
              }else if(parent!=neighbor) return true;
        }
        return false;
    }

    public boolean hasCycleDirected(){
     HashSet<String>visted = new HashSet<>();
     HashSet<String> callStack = new HashSet<>();
     for (String string : adjList.keySet()) {
        if(!visted.contains(string)){
            if(helperFunDfs(string,visted,callStack))return true;
        }
     }
     return false;
    }
    public boolean helperFunDfs(String  node, HashSet<String>vist,HashSet<String>callstack){
        if(callstack.contains(node)) return true;
        if(vist.contains(node)) return false;
        vist.add(node);
        callstack.add(node);
        for (String string : this.adjList.get(node)) {
              if(vist.contains(string)) return true;
        }
        callstack.remove(node);
        return false;
    }
    public static void main(String[] args) {
        DFS_BFS graph = new DFS_BFS();
        Map<String, Boolean> visited = new HashMap<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        // graph.printGraph();
        // graph.Dfs(visited, "C");
        // graph.Bfs(visited, "A");
        // System.out.println(graph.CountConnectedNode());
        // System.out.println(graph.CountConnectedNodeDFs(visited, "A"));
        System.out.println(graph.HasCycle());
        System.out.println(graph.hasCycleDirected());
    }
}
