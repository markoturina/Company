package hr.eriksson.company.CompanyDataBase.company;

import java.util.Date;

public class Company {

    private int id;
    private String name;
    private Date foundation_date;
    private int postal_code;

    public Company() {

    }

    public Company(int id, String name, Date foundation_date, int postal_code) {
        super();
        this.id = id;
        this.name = name;
        this.foundation_date = foundation_date;
        this.postal_code = postal_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundation_date() {
        return foundation_date;
    }

    public void setFoundation_date(Date foundation_date) {
        this.foundation_date = foundation_date;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }


}
