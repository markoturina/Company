package hr.eriksson.company.CompanyDataBase.employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

@SuppressWarnings("SqlNoDataSourceInspection")
@Repository
public class EmployeeDao {
    NamedParameterJdbcTemplate template;

    public EmployeeDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Employee> findAll() {
        return template.query("select * from employee", new EmployeeRowMapper());
    }


    public int insertEmployee(Employee emp) {
        final String sql = "insert into employee values(:id,:company_id,:first_name,:last_name,:salary,:postal_code)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", emp.getId())
                .addValue("company_id", emp.getCompany_id())
                .addValue("first_name", emp.getName().split(" ")[0])
                .addValue("last_name", emp.getName().split(" ")[1])
                .addValue("salary", emp.getSalary())
                .addValue("postal_code", emp.getPostal_code());
        return template.update(sql, param, holder);
    }

    public int updateEmployee(Employee emp) {
        final String sql = "update employee set company_id=:company_id, first_name=:first_name, " +
                "last_name=:last_name, salary=:salary, postal_code=:postal_code " +
                "where id = " + emp.getId();

//		KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", emp.getId())
                .addValue("company_id", emp.getCompany_id())
                .addValue("first_name", emp.getName().split(" ")[0])
                .addValue("last_name", emp.getName().split(" ")[1])
                .addValue("salary", emp.getSalary())
                .addValue("postal_code", emp.getPostal_code());
        return template.update(sql, param);

    }

    public void deleteEmployee(int id) {
        final String sql = "delete from employee where id=:id";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }


}
