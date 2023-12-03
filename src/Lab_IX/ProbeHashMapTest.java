package Lab_IX;

public class ProbeHashMapTest {
    public static void main(String[] args) {
        // Create an instance of ProbeHashMap
        ProbeHashMap<String, Integer> probeHashMap = new ProbeHashMap<>();

        // Test putting key-value pairs
        probeHashMap.put("one", 1);
        probeHashMap.put("two", 2);
        probeHashMap.put("three", 3);

        // Test getting values
        System.out.println("Value for key 'one': " + probeHashMap.get("one")); // Should print 1
        System.out.println("Value for key 'two': " + probeHashMap.get("two")); // Should print 2
        System.out.println("Value for key 'three': " + probeHashMap.get("three")); // Should print 3

        // Test removing a key-value pair
        probeHashMap.remove("two");
        System.out.println("Value for key 'two' after removal: " + probeHashMap.get("two")); // Should print null

        // Test iterating through entries
        System.out.println("Entries in the map:");
        for (Entry<String, Integer> entry : probeHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
