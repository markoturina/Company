package hr.eriksson.company.CompanyDataBase.company;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CompanyRowMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int arg1) throws SQLException {

        Company com = new Company();

        com.setId(rs.getInt("company_id"));
        com.setName(rs.getString("Name"));
        com.setFoundation_date(rs.getDate("Foundation_date"));
        com.setPostal_code(rs.getInt("Postal_code"));

        return com;
    }

}
