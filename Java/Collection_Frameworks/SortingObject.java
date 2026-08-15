package Java.Collection_Frameworks;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class SortingObject {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Satya", 50000));
        employees.add(new Employee(2, "Sabya", 80000));

        employees.sort(Comparator.comparingDouble(e -> e.salary));

        for(Employee em : employees){
            System.out.println("id = "+ em.id + " name = " + em.name + " salary = " + em.salary);
        }
        
    }
}

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
