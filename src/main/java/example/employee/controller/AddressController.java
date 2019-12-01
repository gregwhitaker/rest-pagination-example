package example.employee.controller;

import example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/{id}/addresses/home",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getHomeAddressForEmployee(long employeeId) {
        return null;
    }

    @GetMapping(value = "/employees/{id}/addresses/work",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWorkAddressForEmployee(long employeeId) {
        return null;
    }
}
