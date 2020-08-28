package Method;

import IO.InOut;
import Objects.Accountant;
import Objects.Person;
import Objects.PersonManagement;
import Objects.SalesMan;
import java.util.ArrayList;
import java.util.Scanner;

public class ListPerson {
    int id, salary, sold_products, OT_days;
    String role;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> list = new ArrayList<>();

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }

    public void add() {
        System.out.println("\nEnter the following details to ADD list:\n");
//        System.out.println("Enter id: ");
//        do {
//            try {
//                id = Integer.parseInt(scanner.nextLine());
//                break;
//            }catch (Exception ignored){}
//            System.out.println("Pleas re-enter id: ");
//        }while (true);

        System.out.println("Enter role:\n   1). SalesMan\n   2). Accountant");
        String choice = scanner.nextLine();
        do {
            switch (choice) {
                case "1" -> role = "SalesMan";
                case "2" -> role = "Accountant";
                default -> System.out.println("Pleas re-enter role: ");
            }
        } while (!role.equalsIgnoreCase("SalesMan") && !role.equalsIgnoreCase("Accountant"));

        if (role.equalsIgnoreCase("SalesMan")) {
            System.out.println("Enter the number of products had sold: ");
            do {
                try {
                    sold_products = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (Exception ignored) {}
                System.out.println("Pleas re-enter number of product had sold: ");
            }while (true);
            System.out.println("Enter salary: ");
            do {
                try {
                    salary = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (Exception ignored){}
                System.out.println("Pleas re-enter salary: ");
            }while (true);
            list.add(new SalesMan(checkID(), sold_products, salary, role));
            PersonManagement.display(list);
        }

        if (role.equalsIgnoreCase("Accountant")) {
            System.out.println("Enter the number of OT day: ");
            do {
                try {
                    OT_days = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (Exception ignored){}
                System.out.println("Pleas re-enter number of OT day: ");
            }while (true);
            System.out.println("Enter salary: ");
            do {
                try {
                    salary = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (Exception ignored){}
                System.out.println("Pleas re-enter salary: ");
            }while (true);
            list.add(new Accountant(checkID(), OT_days, salary, role));
            PersonManagement.display(list);
        }
    }

    public void search() {
        System.out.println("Enter the Employee ID to search: ");
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception ignored){}
            System.out.println("Please re-enter id: ");
        }while (true);
        int i = 0;
        for (Person person : list) {
            if (person.getId() == id) {
                System.out.println(person);
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Not found !");
        }
    }

    public void edit() {
        System.out.println("Enter the Employee ID to edit details: ");
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception ignored){}
            System.out.println("Please re-enter id: ");
        }while (true);

        Person person = getPersonById(id);
        int i = 0;
        if (person instanceof Accountant){
            i++;
            do {
                String choice;
                System.out.println("\nEdit employee details :\n" +
                        "1). OT day\n" +
                        "2). Salary\n" +
                        "0). Back\n");
                System.out.println("Enter your choice : ");
                do {
                    try {
                        choice = scanner.nextLine();
                        break;
                    }catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                }while (true);

                switch (choice) {
                    case "1" -> {
                        System.out.println("Enter new number of OT day: ");
                        do {
                            try {
                                OT_days = Integer.parseInt(scanner.nextLine());
                                break;
                            }catch (Exception ignored){}
                            System.out.println("Please re-enter number of OT day: ");
                        }while (true);
                        ((Accountant) person).setOT_days(OT_days);
                        System.out.println(person + "\n");
                    }
                    case "2" -> {
                        System.out.println("Enter new salary: ");
                        do {
                            try {
                                salary = Integer.parseInt(scanner.nextLine());
                                break;
                            }catch (Exception ignored){}
                            System.out.println("Please re-enter salary: ");
                        }while (true);
                        person.setSalary(salary);
                        System.out.println(person + "\n");
                    }
                    case "0" -> i++;
                    default -> System.out.println("Please enter correct choice");
                }
            } while (i == 1);
        }if (person instanceof SalesMan){
            i++;
            do {
                String choice;
                System.out.println("\nEdit employee details :\n" +
                        "1). Sold product\n" +
                        "2). Salary\n" +
                        "0). Back\n");
                System.out.println("Enter your choice: ");
                do {
                    try {
                        choice = scanner.nextLine();
                        break;
                    }catch (Exception e) {
                        System.out.println("Wrong input");
                    }
                }while (true);

                switch (choice) {
                    case "1" -> {
                        System.out.println("Enter new number of product sold: ");
                        do {
                            try {
                                sold_products = Integer.parseInt(scanner.nextLine());
                                break;
                            }catch (Exception ignored){}
                            System.out.println("Please re-enter number product had sold: ");
                        }while (true);
                        ((SalesMan) person).setSold_products(sold_products);
                        System.out.println(person + "\n");
                    }
                    case "2" -> {
                        System.out.println("Enter new salary: ");
                        do {
                            try {
                                salary = Integer.parseInt(scanner.nextLine());
                                break;
                            }catch (Exception ignored){}
                            System.out.println("Please re-enter salary : ");
                        }while (true);
                        person.setSalary(salary);
                        System.out.println(person + "\n");
                    }
                    case "0" -> i++;
                    default -> System.out.println("Please enter correct choice");
                }
            }while (i == 1);
        }
    }

    public void delete() {
        System.out.println("\nEnter Employee ID to DELETE from the Database :");
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception ignored){}
            System.out.println("Please re-enter id: ");
        }while (true);
        int k = 0;
        try {
            for (Person person : list) {
                if (id == person.getId()) {
                    list.remove(person);
                    PersonManagement.display(list);
                    k++;
                }
            }
            if (k == 0) {
                System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
            }
        }catch (Exception ignored){}
    }

    public void showAll() {
        PersonManagement.display(list);
    }

    public void printToFile() {
        InOut io = new InOut();
        io.writeObjectToFile(list);
        System.out.println("\nYou have chosen EXIT !! Saving Files and closing the program.");
        scanner.close();
        System.exit(0);
    }


    public Person getPersonById(int id){
        for (Person person : list) {
            if (person.getId() == id) {
                return person;
            }
        }return null;
    }

    public int checkID() {
        int checkID = 0;
        for (Person person : list) {
            if (checkID < person.getId()) {
                checkID = person.getId();
            }
        }
        return checkID;
    }

    public void getSalesManSalary() {
        int SalesManSalary = 0;
        for (Person person : list) {
            if (person.getRole().equalsIgnoreCase("SalesMan")) SalesManSalary += person.getSalary();
        }
        System.out.println("Salary of Salesman: " + SalesManSalary + " VND ");
    }

    public void getAccountantSalary() {
        int AccountantSalary = 0;
        for (Person person : list) {
            if (person.getRole().equalsIgnoreCase("Accountant")) AccountantSalary += person.getSalary();
        }
        System.out.println("Salary of Accountant: " + AccountantSalary + " VND ");
    }
}