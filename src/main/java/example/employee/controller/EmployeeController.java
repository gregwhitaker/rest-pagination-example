package example.employee.controller;

import example.employee.controller.model.GetEmployeeResponse;
import example.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees() {
        return null;
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployee(@PathVariable("id") long id) {
        return null;
    }
}
