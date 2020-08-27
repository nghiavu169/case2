package Main;

import IO.InOut;
import Method.ListPerson;
import Objects.Person;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListPerson listPerson = new ListPerson();
        Scanner scanner = new Scanner(System.in);
        InOut io = new InOut();
        ArrayList<Person> list = io.readFromFile();
        if (list == null) list = new ArrayList<>();
        listPerson.setList(list);
        do {
            System.out.println("\n*********Welcome to the Employee Management System**********\n");
            System.out.println("1). Add Employee to the DataBase\n" +
                    "2). Search for Employee\n" +
                    "3). Edit Employee details\n" +
                    "4). Delete Employee Details\n" +
                    "5). Display all Employees working in this company\n" +
                    "6). EXIT\n");
            System.out.println("Enter your choice : ");
            String choice;
            do {
                try {
                    choice = scanner.nextLine();
                    break;
                }catch (Exception ignored){}
            }while (true);

            switch (choice){
                case "1" -> listPerson.add();
                case "2" -> listPerson.search();
                case "3" -> listPerson.edit();
                case "4" -> listPerson.delete();
                case "5" -> listPerson.showAll();
                case "6" -> listPerson.printToFile();
                default -> System.out.println("Please enter the correct choice form the list: ");
            }
        }while (true);
    }
}
