package Lab_IX;
import java.util.Map;

public class ChainHashMapTest {

    public static void main(String[] args) {
        testEmptyConstructor();
        testConstructorWithCapacity();
        testConstructorWithCapacityAndPrime();
        testPutAndGet();
        testRemove();
        testEntrySet();
    }

    private static void testEmptyConstructor() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        System.out.println("Test Empty Constructor:");
        System.out.println("Is empty? " + map.isEmpty());
        System.out.println("Size: " + map.size());
        System.out.println();
    }

    private static void testConstructorWithCapacity() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>(10);
        System.out.println("Test Constructor With Capacity:");
        System.out.println("Is empty? " + map.isEmpty());
        System.out.println("Size: " + map.size());
        System.out.println();
    }

    private static void testConstructorWithCapacityAndPrime() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>(10, 7);
        System.out.println("Test Constructor With Capacity and Prime:");
        System.out.println("Is empty? " + map.isEmpty());
        System.out.println("Size: " + map.size());
        System.out.println();
    }

    private static void testPutAndGet() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        System.out.println("Test Put and Get:");
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'one': " + map.get("one"));
        System.out.println("Value for 'two': " + map.get("two"));
        System.out.println("Value for 'three': " + map.get("three"));
        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());
        System.out.println();
    }

    private static void testRemove() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        System.out.println("Test Remove:");
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Size before removal: " + map.size());
        System.out.println("Removed value for 'one': " + map.remove("one"));
        System.out.println("Size after removal: " + map.size());
        System.out.println("Value for 'one' after removal: " + map.get("one"));
        System.out.println();
    }

    private static void testEntrySet() {
        ChainHashMap<String, Integer> map = new ChainHashMap<>();
        System.out.println("Test Entry Set:");
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        Iterable<Entry<String, Integer>> entries = map.entrySet();

        int count = 0;
        for (Entry<String, Integer> entry : entries) {
            count++;
        }

        System.out.println("Number of entries: " + count);
        System.out.println();
    }
}
