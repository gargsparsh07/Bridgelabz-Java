package datastructure.treeandgraphs;

import java.util.*;

public class DetectCycleUndirected {

    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, node, visited, graph))
                    return true;
            }
            else if (neigh != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(0); // cycle
        graph.get(0).add(2);

        boolean[] visited = new boolean[V];

        System.out.println("Cycle Present: " + dfs(0, -1, visited, graph));
    }
}
