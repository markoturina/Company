package hr.eriksson.company.CompanyDataBase.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/company")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @RequestMapping("/company/{id}")
    public Optional<Company> getCompany(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/company") // moze i @PostMapping(value="/topics")
    public String addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/company") // moze i @PostMapping(value="/topics")
    public String updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/company/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        return companyService.deleteCompany(id);
    }
}
