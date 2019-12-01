package example.employee.controller;

import example.employee.controller.model.GetEmployeeResponse;
import example.employee.controller.model.GetEmployeesResponse;
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
     *
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                          @RequestParam(value = "limit", required = false, defaultValue = "25") int limit) {
        GetEmployeesResponse response = new GetEmployeesResponse();

        employeeService.getEmployees(offset, limit).forEach(o -> {

        });

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployee(@PathVariable("id") long id) {
        return null;
    }
}
