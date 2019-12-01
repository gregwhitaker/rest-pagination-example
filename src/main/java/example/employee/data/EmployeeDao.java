package example.employee.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeDao {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDao.class);

    @Autowired
    private DataSource dataSource;

    public Employee getEmployee(long id) {
        try (Connection conn = dataSource.getConnection()) {
            final String sql = "SELECT e.*, d.name AS department_name FROM employees e JOIN departments d on e.department = d.id WHERE e.id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return Employee.from(rs);
                    }

                    // Employee not found
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee from database.", e);
        }
    }
}
