package example.employee.controller;

import example.employee.controller.model.GetEmployeeResponse;
import example.employee.controller.model.GetEmployeesResponse;
import example.employee.data.Employee;
import example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @GetMapping("/employees")
    public ResponseEntity<GetEmployeesResponse> getEmployees(@RequestParam(value = "offset", required = false, defaultValue = "0") long offset,
                                                             @RequestParam(value = "limit", required = false, defaultValue = "25") long limit) {
        return ResponseEntity.ok()
                .body(GetEmployeesResponse.from(employeeService.getEmployees(offset, limit)));
    }

    /**
     * Get a single employee from the system.
     *
     * @param id employee id
     * @return
     */
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee != null) {
            return ResponseEntity.ok(GetEmployeeResponse.from(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
