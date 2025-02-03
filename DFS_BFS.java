import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public class DFS_BFS {
    private Map<String, ArrayList<String>> adjList;
    private Map<String, Map<String, Integer>> weights; // Edge Weights

    public DFS_BFS() {
        adjList = new HashMap<>();
        weights = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
        weights.putIfAbsent(vertex, new HashMap<>()); // Ensure weight map exists
    }

    public void addEdge(String u, String v, int weight) {
        adjList.get(u).add(v); // Add v to u's list
        weights.get(u).put(v, weight); // Store weight
    }

    // Dijkstra's Algorithm
    public void dijkstra(String source) {
        PriorityQueue<Nodes> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        HashMap<String, Integer> destination = new HashMap<>();
        for (String strNode : adjList.keySet()) {
            destination.put(strNode, Integer.MAX_VALUE);
        }
        destination.put(source, 0);
        pq.add(new Nodes(source, 0));
        while (!pq.isEmpty()) {
            Nodes currNode = pq.poll();
            String s = currNode.vertex;
            for (String n : adjList.get(s)) {
                int weight = weights.get(s).get(n);
                int newCost = destination.get(s) + weight;
                if (newCost < destination.get(n)) {
                    destination.put(n, newCost);
                    pq.add(new Nodes(n, newCost));
                }
            }
        }
        System.out.println("Shortest distances from " + source + ":");
        for (String node : destination.keySet()) {
            System.out.println("To " + node + " -> " + destination.get(node));
        }
    }

    public static class Nodes {
        String vertex;
        int cost;

        Nodes(String v, int c) {
            this.vertex = v;
            this.cost = c;
        }
    }

    public static void main(String[] args) {
        DFS_BFS graph = new DFS_BFS();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add weighted edges
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 3);
        graph.addEdge("D", "E", 8);
        graph.addEdge("E", "A", 7);

        // Run Dijkstra from "A"
        graph.dijkstra("A");
    }
}

// public void dijkstra(String source) {
// PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node ->
// node.cost));
// Map<String, Integer> dist = new HashMap<>();
// // Map<String, String> prev = new HashMap<>();
// for (String node : adjList.keySet()) {
// dist.put(node, Integer.MAX_VALUE);
// // prev.put(node, null);
// }
// dist.put(source, 0);
// pq.add(new Node(source, 0));

// while (!pq.isEmpty()) {
// Node curr = pq.poll();
// String u = curr.vertex;

// for (String v : adjList.getOrDefault(u, new ArrayList<>())) {
// int weight = weights.get(u).get(v);
// int newDist = dist.get(u) + weight;

// if (newDist < dist.get(v)) { // Relaxation step
// dist.put(v, newDist);
// // prev.put(v, u);
// pq.add(new Node(v, newDist));
// }
// }
// }

// System.out.println("Shortest distances from " + source + ":");
// for (String node : dist.keySet()) {
// System.out.println("To " + node + " -> " + dist.get(node));
// }
// }

// static class Node {
// String vertex;
// int cost;

// Node(String v, int c) {
// this.vertex = v;
// this.cost = c;
// }
// }
