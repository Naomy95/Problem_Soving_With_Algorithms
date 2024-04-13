//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Random;
//import java.util.Set;
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
//class TabuSearch {
//    private int[] currentSolution;
//    private int[] bestSolution;
//    private int[][] tabuList;
//    private int[] bestEvaluation;
//    private int tabuTenure;
//    private int numItems;
//
//    public TabuSearch(int numItems, int tabuTenure) {
//        this.numItems = numItems;
//        this.tabuTenure = tabuTenure;
//        this.currentSolution = new int[numItems];
//        this.bestSolution = new int[numItems];
//        this.tabuList = new int[numItems][numItems];
//        this.bestEvaluation = new int[2];
//        this.bestEvaluation[1] = Integer.MIN_VALUE;
//    }
//
//    public int[] generateRandomSolution() {
//        Random random = new Random();
//        int[] randomSolution = new int[numItems];
//        for (int i = 0; i < numItems; i++) {
//            randomSolution[i] = random.nextInt(2);
//        }
//        return randomSolution;
//    }
//
//    public int[] evaluateSolution(int[] solution, Item[] items, Thief thief) {
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
//    public void updateTabuList() {
//        for (int i = 0; i < numItems; i++) {
//            for (int j = 0; j < numItems; j++) {
//                if (tabuList[i][j] > 0) {
//                    tabuList[i][j]--;
//                }
//            }
//        }
//    }
//
//    public boolean isTabu(int[] solution, int index1, int index2) {
//        return tabuList[index1][index2] > 0 || tabuList[index2][index1] > 0;
//    }
//
//    public void addTabu(int index1, int index2) {
//        tabuList[index1][index2] = tabuTenure;
//        tabuList[index2][index1] = tabuTenure;
//    }
//
//    public void search(Item[] items, Thief thief, int iterations) {
//        for (int i = 0; i < iterations; i++) {
//            int[] newSolution = generateRandomSolution();
//            int[] newEvaluation = evaluateSolution(newSolution, items, thief);
//
//            boolean improved = newEvaluation[1] > bestEvaluation[1];
//            if (improved || i == 0) {
//                bestSolution = newSolution;
//                bestEvaluation = newEvaluation;
//            }
//
//            for (int j = 0; j < numItems; j++) {
//                for (int k = j + 1; k < numItems; k++) {
//                    if (isTabu(newSolution, j, k)) {
//                        continue;
//                    }
//
//                    int[] neighborSolution = newSolution.clone();
//                    neighborSolution[j] = 1 - neighborSolution[j];
//                    neighborSolution[k] = 1 - neighborSolution[k];
//                    int[] neighborEvaluation = evaluateSolution(neighborSolution, items, thief);
//
//                    if (neighborEvaluation[1] > bestEvaluation[1]) {
//                        bestSolution = neighborSolution;
//                        bestEvaluation = neighborEvaluation;
//                        improved = true;
//                    }
//
//                    if (!improved) {
//                        newSolution = neighborSolution;
//                        newEvaluation = neighborEvaluation;
//                    }
//
//                    addTabu(j, k);
//                    break;
//                }
//                if (improved) {
//                    break;
//                }
//            }
//
//            updateTabuList();
//            thief.currentProfit = 0;
//            thief.currentWeight = 0;
//        }
//    }
//
//    public int[] getBestSolution() {
//        return bestSolution;
//    }
//
//    public int[] getBestEvaluation() {
//        return bestEvaluation;
//    }
//}
//
//public class TTPwithTableSearch {
//
//    public static double distance(City city1, City city2) {
//        return Math.sqrt(Math.pow(city1.x - city2.x, 2) + Math.pow(city1.y - city2.y, 2));
//    }
//
//    public static void main(String[] args) {
//        int numCities = 4;
//        int numItems = 3;
//        int thiefCapacity = 10;
//        int tabuTenure = 5;
//        City[] cities = {new City(0, 0), new City(1, 2), new City(3, 1), new City(5, 3)};
//        Item[] items = {new Item(2, 6, 1), new Item(3, 8, 2), new Item(4, 12, 3)};
//        Thief thief = new Thief(thiefCapacity, 0);
//
//        TabuSearch tabuSearch = new TabuSearch(numItems, tabuTenure);
//        tabuSearch.search(items, thief, 1000);
//
//        int[] bestSolution = tabuSearch.getBestSolution();
//        int[] bestEvaluation = tabuSearch.getBestEvaluation();
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
