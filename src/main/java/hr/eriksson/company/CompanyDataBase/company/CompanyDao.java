package hr.eriksson.company.CompanyDataBase.company;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {

    NamedParameterJdbcTemplate template;

    public CompanyDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Company> findAll() {
        return template.query("select * from company", new CompanyRowMapper());
    }

    public int insertCompany(Company com) {
        final String sql = "insert into company values(:company_id,:name,:foundation_date,:postal_code)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("company_id", com.getId())
                .addValue("name", com.getName())
                .addValue("foundation_date", com.getFoundation_date())
                .addValue("postal_code", com.getPostal_code());
        return template.update(sql, param, holder);
    }


    public int updateCompany(Company com) {
        final String sql = "update company set name=:name, foundation_date=:foundation_date, postal_code=:postal_code where company_id=:company_id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("company_id", com.getId())
                .addValue("name", com.getName())
                .addValue("foundation_date", com.getFoundation_date())
                .addValue("postal_code", com.getPostal_code());
        return template.update(sql, param, holder);
    }


    public void deleteCompany(int id) {
        final String sql = "delete from company where company_id=:company_id";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("company_id", id);
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }


}
