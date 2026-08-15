package Java.Collection_Frameworks;

public class TreeMapInterface {
    public static void main(String[] args) {
        // Create a TreeMap
        java.util.TreeMap<Integer, String> treeMap = new java.util.TreeMap<>();

        // Add elements to the TreeMap
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(5, "Five");
        treeMap.put(4, "Four");

        // Display the TreeMap
        System.out.println("TreeMap: " + treeMap);

        // Access elements in the TreeMap
        System.out.println("Value for key 3: " + treeMap.get(3));
        System.out.println("Value for key 1: " + treeMap.get(1));

        // Remove an element from the TreeMap
        treeMap.remove(2);
        System.out.println("TreeMap after removing key 2: " + treeMap);

        // Iterate through the TreeMap
        System.out.println("Iterating through TreeMap:");
        for (java.util.Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
