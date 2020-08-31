package Objects;

public class Accountant extends Person {
    int id, OT_days, salary;
    String role;

    public Accountant(int id, int OT_days, int salary, String role) {
        this.id = ++id;
        this.OT_days = OT_days;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOT_days() {
        return OT_days;
    }

    public void setOT_days(int OT_days) {
        this.OT_days = OT_days;
    }

    @Override
    public int getSalary() {
        if (OT_days > 0 && OT_days < 10) return salary;
        else return salary + OT_days * 500;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "id=" + id +
                ", OT_days=" + OT_days +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                '}';
    }
}