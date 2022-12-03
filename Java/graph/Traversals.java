package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    // Time Complexity -> O(V+E)
    // Space Complexity -> O(V+E)
    public static void BFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++)
            if (!visited[i])
                BFS(adj, i, visited);
    }

    private static void BFS(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[vertex] = true;
        q.add(vertex);
        while (!q.isEmpty()) {
            int front = q.remove();
            System.out.print(front + " ");
            for (int i : adj.get(front)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    // Time Complexity -> O(V+E)
    // Space Complexity -> O(V+E)
    public static void DFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++)
            if (!visited[i])
                DFSRec(adj, i, visited);
    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i : adj.get(vertex))
            if (!visited[i])
                DFSRec(adj, i, visited);
    }

    public static void main(String[] args) {
        // int v = 5;
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        // for (int i = 0; i < v; i++)
        // adj.add(new ArrayList<>());
        // Graph.addEdge(adj, 0, 4);
        // Graph.addEdge(adj, 1, 2);
        // Graph.addEdge(adj, 1, 3);
        // Graph.addEdge(adj, 1, 4);
        // Graph.addEdge(adj, 2, 3);
        // Graph.addEdge(adj, 3, 4);
        // BFS(adj);
        // System.out.println();
        // DFS(adj);

        Graph ob = new Graph(5);
        ob.addEdge(0, 4);
        ob.addEdge(1, 2);
        ob.addEdge(1, 3);
        ob.addEdge(1, 4);
        ob.addEdge(2, 3);
        ob.addEdge(3, 4);
        BFS(ob.adj);
        System.out.println();
        DFS(ob.adj);
    }
}
