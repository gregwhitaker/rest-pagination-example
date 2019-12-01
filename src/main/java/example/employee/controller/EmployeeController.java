package example.employee.controller;

import example.employee.controller.model.GetEmployeeResponse;
import example.employee.controller.model.GetEmployeesResponse;
import example.employee.data.model.Employee;
import example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for accessing employee information.
 */
@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get a list of all employees in the system.
     *
     * @param offset number of records to offset for pagination
     * @param limit total number of records to return for pagination
     * @return list of employee's info
     */
    @GetMapping(value = "/employees",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetEmployeesResponse> getEmployees(@RequestParam(value = "offset", required = false, defaultValue = "0") long offset,
                                                             @RequestParam(value = "limit", required = false, defaultValue = "25") long limit) {
        // Enforce minimum offset
        if (offset < 0) {
            offset = 0;
        }

        // Enforce minimum limit
        if (limit < 0) {
            limit = 25;
        }

        // Enforce maximum limit
        if (limit > 100) {
            limit = 100;
        }

        return ResponseEntity.ok()
                .body(GetEmployeesResponse.from(employeeService.getEmployees(offset, limit), offset, limit));
    }

    /**
     * Get a single employee from the system.
     *
     * @param id employee id
     * @return employee info
     */
    @GetMapping(value = "/employees/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetEmployeeResponse> getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee != null) {
            return ResponseEntity.ok(GetEmployeeResponse.from(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
