package datastructure.treeandgraphs;

import java.util.*;

public class DijkstraShortestPath {

    static class Pair {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
    }

    public static void main(String[] args) {

        int V = 5;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 2));
        graph.get(0).add(new Pair(2, 4));
        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(3, 7));
        graph.get(2).add(new Pair(4, 3));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (Pair neigh : graph.get(cur.node)) {
                if (dist[cur.node] + neigh.dist < dist[neigh.node]) {
                    dist[neigh.node] = dist[cur.node] + neigh.dist;
                    pq.add(new Pair(neigh.node, dist[neigh.node]));
                }
            }
        }

        System.out.println("Shortest distances: " + Arrays.toString(dist));
    }
}
