package hr.eriksson.company.CompanyDataBase.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public List<Company> getAllCompanies() {
        return companyDao.findAll();
    }

    public Optional<Company> getCompany(int id) {
        return companyDao.findAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    public String addCompany(Company company) {
        if (companyDao.findAll().stream().filter(p -> p.getId() == company.getId()).count() > 0) {
            return "Error, company with this ID already exists!";
        }

        if (companyDao.insertCompany(company) == 1) {
            return "Company successfully added!";
        } else {
            return "Error, company was not added!";
        }
    }

    public String updateCompany(Company company) {
        if (company.getId() < 0) {
            return "Error, company ID must be greater than 0!";
        }

        if (companyDao.updateCompany(company) == 1) {
            return "Company successfully updated!";
        } else {
            return "Error, company was not updated!";
        }
    }

    public String deleteCompany(int id) {
        if (companyDao.findAll().stream().filter(p -> p.getId() == id).count() > 0) {
            companyDao.deleteCompany(id);
            return "Company successfully deleted";
        }
        return "Company with given ID does not exist!";
    }


}
