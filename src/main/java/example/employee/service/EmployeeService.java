package example.employee.service;

import example.employee.data.model.Employee;
import example.employee.data.EmployeeDao;
import example.employee.data.model.EmployeeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(long id) {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getEmployees(long offset, long limit) {
        return employeeDao.getEmployees(offset, limit);
    }

    public EmployeeAddress getEmployeeHomeAddress(long employeeId) {
        return employeeDao.getEmployeeHomeAddress(employeeId);
    }

    public EmployeeAddress getEmployeeWorkAddress(long employeeId) {
        return employeeDao.getEmployeeWorkAddress(employeeId);
    }
}
