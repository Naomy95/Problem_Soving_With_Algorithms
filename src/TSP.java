import java.util.*;

public class TSP {
    static int[][] graph;

    public static void main(String[] args) {
        // Example graph representing distances between cities
        graph = new int[][] {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int n = graph.length;
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            path.add(i);
        }

        int minCost = Integer.MAX_VALUE;
        List<Integer> minPath = new ArrayList<>();

        // Find all permutations of cities
        do {
            int cost = calculateCost(path);
            if (cost < minCost) {
                minCost = cost;
                minPath = new ArrayList<>(path);
            }
        } while (nextPermutation(path));

        System.out.println("Minimum cost: " + minCost);
        System.out.println("Optimal path: " + minPath);
    }

    // Calculate the cost of a path
    static int calculateCost(List<Integer> path) {
        int cost = 0;
        int n = path.size();
        for (int i = 0; i < n - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            cost += graph[from][to];
        }
        cost += graph[path.get(n - 1)][path.get(0)]; // Return to the starting city
        return cost;
    }

    // Generate the next permutation of a list
    static boolean nextPermutation(List<Integer> list) {
        int n = list.size();
        int i = n - 2;
        while (i >= 0 && list.get(i) >= list.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (list.get(j) <= list.get(i)) {
            j--;
        }
        Collections.swap(list, i, j);
        Collections.reverse(list.subList(i + 1, n));
        return true;
    }
}
