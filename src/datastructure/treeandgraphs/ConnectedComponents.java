package datastructure.treeandgraphs;

import java.util.*;

public class ConnectedComponents {

    static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neigh : graph.get(node))
            if (!visited[neigh])
                dfs(neigh, visited, graph);
    }

    public static void main(String[] args) {

        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(2).add(3);
        graph.get(3).add(2);

        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                count++;
            }
        }

        System.out.println("Connected Components = " + count);
    }
}
