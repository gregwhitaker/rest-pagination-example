package example.employee.controller;

import example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<?> getHomeAddressForEmployee(long employeeId) {
        return null;
    }

    public ResponseEntity<?> getWorkAddressForEmployee(long employeeId) {
        return null;
    }
}
