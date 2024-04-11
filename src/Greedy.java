//import java.util.*;
//
////class Item {
////    int weight;
////    int value;
////    double valuePerWeight;
////
////    public Item(int weight, int value) {
////        this.weight = weight;
////        this.value = value;
////        this.valuePerWeight = (double) value / weight;
////    }
////}
////
////class City {
////    int index;
////    double x;
////    double y;
////
////    public City(int index, double x, double y) {
////        this.index = index;
////        this.x = x;
////        this.y = y;
////    }
////}
//
//class Solution {
//    public static void main(String[] args) {
//        List<Item> items = new ArrayList<>();
//        items.add(new Item(2, 40));
//        items.add(new Item(3, 50));
//        items.add(new Item(5, 100));
//
//        List<City> cities = new ArrayList<>();
//        cities.add(new City(0, 0, 0));
//        cities.add(new City(1, 1, 3));
//        cities.add(new City(2, 3, 1));
//        cities.add(new City(3, 4, 4));
//
//        int capacity = 7; // Capacity of the thief's knapsack
//
//        greedy(items, cities, capacity);
//    }
//
//    public static void greedy(List<Item> items, List<City> cities, int capacity) {
//        // Sort items by value per weight in descending order
//        items.sort((a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));
//
//        boolean[] visited = new boolean[cities.size()];
//        int currentCity = 0; // Start from city 0
//
//        int totalValue = 0;
//        int totalWeight = 0;
//
//        for (Item item : items) {
//            for (int i = currentCity; i < cities.size(); i++) {
//                if (!visited[i] && totalWeight + item.weight <= capacity) {
//                    visited[i] = true;
//                    totalValue += item.value;
//                    totalWeight += item.weight;
//                    currentCity = i;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("Total value: " + totalValue);
//        System.out.println("Total weight: " + totalWeight);
//    }
//}
