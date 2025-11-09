package base;

import java.util.*;
import java.util.stream.Collectors;

public class Check {

    record Employee(String name, String department, double salary) {};

    public static void main(String[] args) {
        // Sample data
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 90000),
                new Employee("Bob", "Engineering", 75000),
                new Employee("Charlie", "HR", 65000),
                new Employee("Diana", "HR", 85000),
                new Employee("Ethan", "Sales", 55000),
                new Employee("Fiona", "Sales", 95000)
        );

        // Filter employees with salary > 70,000 and group by department
        Map<String, List<Employee>> empGrp  = employees.stream().filter(e -> e.salary() > 70000).collect(Collectors.groupingBy(Employee::department));

        // Print the grouped result
        empGrp.forEach((dept, empGroup) -> {
            empGroup.forEach(emp -> System.out.println("Name:"+emp.name));
        });

    }
}
