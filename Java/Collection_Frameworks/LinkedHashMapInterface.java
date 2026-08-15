package Java.Collection_Frameworks;

import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapInterface {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println(map);
    }
}
