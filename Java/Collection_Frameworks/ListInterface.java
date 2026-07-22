
/*

-> List stores elements in insertion order and allows duplicates.


*/


package Java.Collection_Frameworks;

import java.util.List;
import java.util.ArrayList;

public class ListInterface {
    public static void main(String[] args) {
        
        // crating the list
        List<String> names = new ArrayList<>();
        names.add("Sabya");
        names.add("Amit");
        names.add("Sabya");
        names.add("Suvam");

        System.out.println(names.get(0));
        names.set(2, "satya");
        System.out.println(names.get(2));
        names.remove(2);
        System.out.println(names.get(2));
        System.out.println(names.getClass());
    }
}
