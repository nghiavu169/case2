package Objects;

public class SalesMan extends Person {
    int id, sold_products, salary;
    String role;

    public SalesMan(int id, int sold_products, int salary, String role) {
        this.id = ++id;
        this.sold_products = sold_products;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSold_products() {
        return sold_products;
    }

    public void setSold_products(int sold_products) {
        this.sold_products = sold_products;
    }

    @Override
    public int getSalary() {
        if (sold_products > 0 && sold_products < 30) return salary;
        else return salary + sold_products * 500;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
