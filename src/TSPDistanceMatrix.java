import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class TSPDistanceMatrix {

    public static double[][] calculateDistanceMatrix(double[][] coordinates) {
        int numCities = coordinates.length;
        double[][] distanceMatrix = new double[numCities][numCities];

        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (i == j) {
                    distanceMatrix[i][j] = 0; // Distance from a city to itself is 0
                } else {
                    distanceMatrix[i][j] = calculateDistance(coordinates[i][0], coordinates[i][1],
                            coordinates[j][0], coordinates[j][1]);
                }
            }
        }
        return distanceMatrix;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double[][] coordinates = {
                {565.0, 575.0},
                {25.0, 185.0},
                {345.0, 750.0},
                {945.0, 685.0},
                // Add more coordinates here
        };

        double[][] distanceMatrix = calculateDistanceMatrix(coordinates);

        // Print the distance matrix
        for (double[] row : distanceMatrix) {
            System.out.println(Arrays.toString(row));
        }
        List<Integer> shortestPath = nearestNeighbor(distanceMatrix);

        // Output shortest path
        System.out.println("Shortest Path: " + shortestPath);
    }

    private static List<Integer> nearestNeighbor(double[][] distanceMatrix) {
        int numCities = distanceMatrix.length;
        boolean[] visited = new boolean[numCities];
        List<Integer> shortestPath = new ArrayList<>();

        // Start from city 0
        int currentCity = 0;
        shortestPath.add(currentCity);
        visited[currentCity] = true;

        // Repeat until all cities are visited
        while (shortestPath.size() < numCities) {
            int nearestCity = -1;
            double minDistance = Double.MAX_VALUE;

            // Find the nearest unvisited city
            for (int nextCity = 0; nextCity < numCities; nextCity++) {
                if (!visited[nextCity] && distanceMatrix[currentCity][nextCity] < minDistance) {
                    nearestCity = nextCity;
                    minDistance = distanceMatrix[currentCity][nextCity];
                }
            }

            // Move to the nearest unvisited city
            shortestPath.add(nearestCity);
            visited[nearestCity] = true;
            currentCity = nearestCity;
        }

        // Return to the starting city to complete the cycle
//        shortestPath.add(0);

        return shortestPath;
    }
}