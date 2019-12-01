package example.employee.controller;

import example.employee.controller.model.GetEmployeeAddressResponse;
import example.employee.data.model.EmployeeAddress;
import example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for accessing employee address information.
 */
@RestController
public class AddressController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Gets the employee's home address.
     *
     * @param employeeId employee id
     * @return employee's home address if available
     */
    @GetMapping(value = "/employees/{id}/addresses/home",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getHomeAddressForEmployee(@PathVariable("id") long employeeId) {
        EmployeeAddress address = employeeService.getEmployeeHomeAddress(employeeId);

        if (address != null) {
            return ResponseEntity.ok(GetEmployeeAddressResponse.from(address));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Gets the employee's work address.
     *
     * @param employeeId employee id
     * @return employee's work address if available
     */
    @GetMapping(value = "/employees/{id}/addresses/work",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getWorkAddressForEmployee(@PathVariable("id") long employeeId) {
        EmployeeAddress address = employeeService.getEmployeeWorkAddress(employeeId);

        if (address != null) {
            return ResponseEntity.ok(GetEmployeeAddressResponse.from(address));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
