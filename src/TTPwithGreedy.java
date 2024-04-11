//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
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
//public class TTPwithGreedy {
//
//    public static double distance(City city1, City city2) {
//        return Math.sqrt(Math.pow(city1.x - city2.x, 2) + Math.pow(city1.y - city2.y, 2));
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
//        // Sort items by decreasing profit density (profit / weight)
//        ArrayList<Item> itemList = new ArrayList<>();
//        for (Item item : items) {
//            itemList.add(item);
//        }
//        Collections.sort(itemList, new Comparator<Item>() {
//            @Override
//            public int compare(Item item1, Item item2) {
//                double density1 = (double) item1.profit / item1.weight;
//                double density2 = (double) item2.profit / item2.weight;
//                return Double.compare(density2, density1);
//            }
//        });
//
//        // Greedy algorithm to pick items
//        for (Item item : itemList) {
//            if (thief.currentWeight + item.weight <= thief.capacity) {
//                thief.currentWeight += item.weight;
//                thief.currentProfit += item.profit;
//                System.out.println("Picked item " + item.city + " with weight " + item.weight + " and profit " + item.profit);
//            }
//        }
//
//        System.out.println("Total profit: " + thief.currentProfit);
//    }
//}
