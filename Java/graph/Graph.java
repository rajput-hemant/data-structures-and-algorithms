package graph;

import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> adj;
    static private int V;

    Graph(int vertex) {
        V = vertex;
        adj = new ArrayList<ArrayList<Integer>>(vertex);
        for (int i = 0; i < vertex; i++)
            adj.add(new ArrayList<>(V));
    }

    public void addEdge(int u, int v) {
        if (u >= V)
            throw new IndexOutOfBoundsException("Index " + u + " out of bounds for length " + V);
        if (v >= V)
            throw new IndexOutOfBoundsException("Index " + v + " out of bounds for length " + V);
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        if (u >= adj.size())
            throw new IndexOutOfBoundsException("Index " + u + " out of bounds for length " + adj.size());
        if (v >= adj.size())
            throw new IndexOutOfBoundsException("Index " + v + " out of bounds for length " + adj.size());
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printAdjList() {
        for (int i = 0; i < adj.size() - 1; i++) {
            System.out.print("'" + i + "' ->  ");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print("\b| " + adj.get(i).get(j) + " |");
            System.out.println();
        }
    }

    public static void printAdjList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size() - 1; i++) {
            System.out.print("'" + i + "' ->  ");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print("\b| " + adj.get(i).get(j) + " |");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int v = 5;
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        // for (int i = 0; i < v; i++)
        // adj.add(new ArrayList<>());
        // addEdge(adj, 0, 1);
        // addEdge(adj, 0, 4);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 1, 3);
        // addEdge(adj, 1, 4);
        // addEdge(adj, 2, 3);
        // addEdge(adj, 3, 4);
        // printAdjList(adj);

        Graph ob = new Graph(5);
        ob.addEdge(0, 1);
        ob.addEdge(0, 2);
        ob.addEdge(1, 2);
        ob.addEdge(1, 5);
        ob.printAdjList();
    }
}
