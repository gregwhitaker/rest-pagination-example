package example.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.employee.data.Employee;

@JsonPropertyOrder({
        "id"
})
public class GetEmployeeResponse {

    public static GetEmployeesResponse from(Employee employee) {
        GetEmployeesResponse response = new GetEmployeesResponse();

        return response;
    }

    private long id;
}
