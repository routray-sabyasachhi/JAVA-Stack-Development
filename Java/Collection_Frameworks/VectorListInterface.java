/**
 * VectorListInterface
 *-> It is similar to arraylist, but it is synchronized.
 *-> Thread safe for Individual operations. 
 *-> Slower than arrayList in single threded code.
 *-> Don't include null values it thhrows exception outof boud access.
 */
package Java.Collection_Frameworks;

import java.util.Vector;

public class VectorListInterface {
    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();
        nums.add(34);
        nums.add(46);
        nums.add(2, 27);

        System.out.println(nums); // access entire array
        System.out.println(nums.get(1));

        nums.set(1, 10);
        
        System.out.println(nums.get(1));
    }
}
