package Java.Collection_Frameworks;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingCollection {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(20,50,10));

        Collections.sort(numbers);
        System.out.println(numbers);

        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);
    }
}
