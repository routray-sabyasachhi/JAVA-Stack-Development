package Java.Collection_Frameworks;

import java.util.Map;
import java.util.HashMap;

public class MapInterface {
    public static void main(String[] args) {

        Map<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "Sabya");
        hmap.put(2, "Satya");
        hmap.put(1, "laxmi"); // over-ride on key 1
       
        System.out.println(hmap); // {1=laxmi, 2=Satya}
        System.out.println(hmap.get(2));
        System.out.println(hmap.remove(1));
        System.out.println(hmap);

        System.out.println(hmap.containsKey(1));
        hmap.put(3, "Ajay");
        System.out.println(hmap.keySet());

        System.out.println(hmap.entrySet());

        hmap.putIfAbsent(1, "Sabya");
        System.out.println(hmap);

        
    }
}
