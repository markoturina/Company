package hr.eriksson.company.CompanyDataBase.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hr.eriksson.company.CompanyDataBase.company.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;


    public Optional<Employee> getEmployee(int id) {
        return employeeDao.findAll().stream().filter(p -> p.getId() == id).findAny();
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public List<Employee> getCompanyEmployees(int company_id) {
        return employeeDao.findAll().stream().filter(p -> p.getCompany_id() == company_id).collect(Collectors.toList());
    }

    public String addEmployee(Employee emp, int company_id) {
        if (employeeDao.findAll().stream().filter(p -> p.getId() == emp.getId()).count() > 0) {
            return "Error, employee with this ID already exists!";
        }

        emp.setCompany_id(company_id);

        if (employeeDao.insertEmployee(emp) == 1) {
            return "Employee successfully added!";
        } else {
            return "Error, employee was not added!";
        }
    }

    public String updateEmployee(Employee emp) {
        if (emp.getId() < 0) {
            return "Error, employee id must be greater than 0!";
        }


        if (companyDao.findAll().stream().filter(p -> p.getId() == emp.getCompany_id()).count() == 1) {
            if (employeeDao.updateEmployee(emp) == 1) {
                return "Employee successfully updated!";
            } else {
                return "Error, employee was not updated!";
            }
        } else {
            return "Company with that ID does not exist!";
        }
    }

    public String deleteEmployee(Integer id) {
        if (id == null) {
            return "To delete a employee you must give employee ID.\n E.g. /employees?id=5";
        }

        if (employeeDao.findAll().stream().filter(p -> p.getId() == id).count() == 1) {
            employeeDao.deleteEmployee(id);
            return "Employee successfully deleted!";
        } else {
            return "Employee with ID " + id + " does not exist";
        }

    }

}
