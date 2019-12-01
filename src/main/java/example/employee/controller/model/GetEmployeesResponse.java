package example.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.employee.data.Employee;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "count",
        "employees"
})
public class GetEmployeesResponse {

    public static GetEmployeesResponse from(List<Employee> employees, UriComponentsBuilder uriBuilder) {
        GetEmployeesResponse response = new GetEmployeesResponse();

        if (employees != null || !employees.isEmpty()) {
            response.setCount(employees.size());
            employees.forEach(employee -> response.getEmployees().add(GetEmployeeResponse.from(employee, uriBuilder)));
        }

        return response;
    }

    private int count = 0;
    private List<GetEmployeeResponse> employees = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GetEmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<GetEmployeeResponse> employees) {
        this.employees = employees;
    }
}
