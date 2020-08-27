package Objects;

import java.util.ArrayList;

public class PersonManagement {
    public static void display(ArrayList<Person> list) {
        System.out.println("\n--------------Employee List---------------\n");
        System.out.printf("%-5s%-20s%-15s%n", "ID","Role","salary");
        for (Person employee : list){
            System.out.printf("%-5s%-20s%-15s%n", employee.getId(), employee.getRole(), employee.getSalary());
        }
    }
}
