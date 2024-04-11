//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//class Item {
//    int weight;
//    int profit;
//    int city;
//
//    public Item(int weight, int profit, int city) {
//        this.weight = weight;
//        this.profit = profit;
//        this.city = city;
//    }
//}
//
//class City {
//    int x;
//    int y;
//
//    public City(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//class Thief {
//    int capacity;
//    int currentWeight;
//    int currentProfit;
//    int currentCity;
//
//    public Thief(int capacity, int currentCity) {
//        this.capacity = capacity;
//        this.currentCity = currentCity;
//        this.currentWeight = 0;
//        this.currentProfit = 0;
//    }
//}
//
//public class TTPwithRandomSearch {
//
//    public static double distance(City city1, City city2) {
//        return Math.sqrt(Math.pow(city1.x - city2.x, 2) + Math.pow(city1.y - city2.y, 2));
//    }
//
//    public static int[] getRandomSolution(int[] itemSelection, int numItems) {
//        Random random = new Random();
//        int[] randomSolution = new int[numItems];
//        for (int i = 0; i < numItems; i++) {
//            randomSolution[i] = random.nextInt(2);
//        }
//        return randomSolution;
//    }
//
//    public static int[] evaluateSolution(int[] solution, Item[] items, Thief thief) {
//        int[] result = new int[2]; // [totalWeight, totalProfit]
//        for (int i = 0; i < solution.length; i++) {
//            if (solution[i] == 1 && thief.currentWeight + items[i].weight <= thief.capacity) {
//                thief.currentWeight += items[i].weight;
//                thief.currentProfit += items[i].profit;
//                result[0] += items[i].weight;
//                result[1] += items[i].profit;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int numCities = 4;
//        int numItems = 3;
//        int thiefCapacity = 10;
//        City[] cities = {new City(0, 0), new City(1, 2), new City(3, 1), new City(5, 3)};
//        Item[] items = {new Item(2, 6, 1), new Item(3, 8, 2), new Item(4, 12, 3)};
//        Thief thief = new Thief(thiefCapacity, 0);
//
//        int[] bestSolution = new int[numItems];
//        int[] tempSolution;
//        int[] tempEvaluation;
//        int[] bestEvaluation = new int[2]; // [totalWeight, totalProfit]
//        bestEvaluation[1] = Integer.MIN_VALUE; // Initialize with minimum profit
//
//        int iterations = 1000;
//        for (int i = 0; i < iterations; i++) {
//            tempSolution = getRandomSolution(bestSolution, numItems);
//            tempEvaluation = evaluateSolution(tempSolution, items, thief);
//            if (tempEvaluation[1] > bestEvaluation[1]) {
//                bestSolution = tempSolution;
//                bestEvaluation = tempEvaluation;
//            }
//            thief.currentProfit = 0;
//            thief.currentWeight = 0;
//        }
//
//        System.out.println("Best solution:");
//        for (int i = 0; i < bestSolution.length; i++) {
//            if (bestSolution[i] == 1) {
//                System.out.println("Picked item " + items[i].city + " with weight " + items[i].weight + " and profit " + items[i].profit);
//            }
//        }
//        System.out.println("Total profit: " + bestEvaluation[1]);
//    }
//}
