package example.employee.service;

import example.employee.data.EmployeeDao;
import example.employee.data.model.Employee;
import example.employee.data.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service for accessing employee information.
 */
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Get information for a single employee.
     *
     * @param id employee id
     * @return employee information if found; otherwise <code>null</code>
     */
    public Employee getEmployee(long id) {
        return employeeDao.getEmployee(id);
    }

    /**
     * Gets the information for all employees (paginated).
     *
     * @param offset record offset for pagination
     * @param limit record limit for pagination
     * @return a list of employee's information
     */
    public List<Employee> getEmployees(long offset, long limit) {
        return employeeDao.getEmployees(offset, limit);
    }

    /**
     * Gets the employee's home address if available.
     *
     * @param employeeId employee id
     * @return employee's home address if available; otherwise <code>null</code>
     */
    public EmployeeAddress getEmployeeHomeAddress(long employeeId) {
        return employeeDao.getEmployeeHomeAddress(employeeId);
    }

    /**
     * Gets the employee's work address if available.
     *
     * @param employeeId employee id
     * @return employee's work address if available; otherwise <code>null</code>
     */
    public EmployeeAddress getEmployeeWorkAddress(long employeeId) {
        return employeeDao.getEmployeeWorkAddress(employeeId);
    }
}
