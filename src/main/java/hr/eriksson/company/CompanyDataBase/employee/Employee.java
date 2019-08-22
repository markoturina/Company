package hr.eriksson.company.CompanyDataBase.employee;

public class Employee {

    private int id;
    private int company_id;
    private String name;
    private int salary;
    private int postal_code;

    public Employee() {

    }


    public Employee(int id, int company_id, String name, int salary, int postal_code) {
        super();
        this.id = id;
        this.company_id = company_id;
        this.name = name;
        this.salary = salary;
        this.postal_code = postal_code;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCompany_id() {
        return company_id;
    }


    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public int getPostal_code() {
        return postal_code;
    }


    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }


}
