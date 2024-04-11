//import java.util.Arrays;
//import java.util.Comparator;
//
////class Item {
////   int value;
////   int weight;
////   public Item(int value, int weight) {
////       this.value = value;
////       this.weight = weight;
////}
////}
//
//public class KnapsackGreedy {
//    // Function to solve the knapsack problem using greedy approach
//    public static int knapsackGreedy(Item[] items, int capacity) {
//        // Sort items based on value-to-weight ratio in non-increasing order
//        Arrays.sort(items, Comparator.comparingDouble((Item i) -> (double) i.value / i.weight).reversed());
//
//        int totalValue = 0;
//        int remainingCapacity = capacity;
//
//        for (Item item : items) {
//            if (remainingCapacity >= item.weight) {
//                // Add the entire item
//                totalValue += item.value;
//                remainingCapacity -= item.weight;
//            } else {
//                // Add a fraction of the item to fill remaining capacity
//                totalValue += (double) item.value * remainingCapacity / item.weight;
//                break;
//            }
//        }
//
//        return totalValue;
//    }
//
//    public static void main(String[] args) {
//        Item[] items = {
//                new Item(60, 10),
//                new Item(100, 20),
//                new Item(120, 30)
//        };
//
//        int capacity = 50;
//
//        int maxValue = knapsackGreedy(items, capacity);
//        System.out.println("Maximum value that can be obtained: " + maxValue);
//    }
//}
