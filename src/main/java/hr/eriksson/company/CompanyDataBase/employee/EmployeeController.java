package hr.eriksson.company.CompanyDataBase.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping("/company/{company_id}/employees")
    public List<Employee> getCompanyEmployees(@PathVariable int company_id) {
        return employeeService.getCompanyEmployees(company_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/company/{id}/employees")
    public String addEmployee(@RequestBody Employee emp, @PathVariable int id) {
        return employeeService.addEmployee(emp, id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = {"/company/{id}/employees", "/employees"})
    public String updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
        return employeeService.updateEmployee(emp);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = {"/company/{company_id}/employees", "employees"})
    public String deleteEmployee(@RequestParam(name = "id", required = false) Integer id, @PathVariable String company_id) {
        return employeeService.deleteEmployee(id);
    }
}
