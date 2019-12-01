package example.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.employee.data.Employee;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@JsonPropertyOrder({
        "id",
        "lastName",
        "firstName",
        "department",
        "phone",
        "email",
        "addresses",
        "salary"
})
public class GetEmployeeResponse {

    public static GetEmployeeResponse from(final Employee employee, final UriComponentsBuilder uriBuilder) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setId(employee.getId());
        response.setLastName(employee.getLastName());
        response.setFirstName(employee.getFirstName());
        response.setDepartment(employee.getDepartmentName());

        // phone numbers
        response.setPhone(new HashMap<>());

        if (employee.getHomePhone() != null) {
            response.getPhone().put("home", "+1-" + employee.getHomePhone());
        }

        if (employee.getWorkPhone() != null) {
            response.getPhone().put("work", "+1-" + employee.getWorkPhone());
        }

        // emails
        response.setEmail(new HashMap<>());

        if (employee.getHomeEmail() != null) {
            response.getEmail().put("home", employee.getHomeEmail());
        }

        if (employee.getWorkEmail() != null) {
            response.getEmail().put("work", employee.getWorkEmail());
        }

        // addresses
        response.setAddresses(new HashMap<>());
        uriBuilder.path("/employees/{id}/addresses/{type}");

        if (employee.getHomeAddressId() != null) {
            response.getAddresses().put("home", uriBuilder.buildAndExpand(employee.getId(), "home").toString());
        }

        if (employee.getWorkAddressId() != null) {
            response.getAddresses().put("work", uriBuilder.buildAndExpand(employee.getId(), "work").toString());
        }

        // salary
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        response.setSalary(currencyFormatter.format(employee.getSalary()));

        return response;
    }

    private long id;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("first_name") private String firstName;
    private String department;
    private Map<String, String> phone;
    private Map<String, String> email;
    private Map<String, String> addresses;
    private String salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getPhone() {
        return phone;
    }

    public void setPhone(Map<String, String> phone) {
        this.phone = phone;
    }

    public Map<String, String> getEmail() {
        return email;
    }

    public void setEmail(Map<String, String> email) {
        this.email = email;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
