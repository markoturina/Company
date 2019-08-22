package hr.eriksson.company.CompanyDataBase.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {

        Employee emp = new Employee();

        emp.setId(rs.getInt("id"));
        emp.setCompany_id(rs.getInt("company_id"));
        emp.setName(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
        emp.setSalary(rs.getInt("Salary"));
        emp.setPostal_code(rs.getInt("Postal_code"));

        return emp;
    }


}
