package Method;

import Objects.Person;

import java.util.ArrayList;

public interface ListInterFace {
    void setList(ArrayList<Person> list);
    void add();
    void search();
    void edit();
    void delete();
    void showAll();
    void printToFile();
    Person getPersonById(int id);
    int checkID();
    void getSalesManSalary();
    void getAccountantSalary();
}
