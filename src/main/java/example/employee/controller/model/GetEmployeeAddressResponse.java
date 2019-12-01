package example.employee.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import example.employee.data.model.EmployeeAddress;

/**
 * API response returned when querying employee address information.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street1",
        "street2",
        "city",
        "state",
        "zipCode"
})
public class GetEmployeeAddressResponse {

    public static GetEmployeeAddressResponse from(EmployeeAddress employeeAddress) {
        GetEmployeeAddressResponse response = new GetEmployeeAddressResponse();
        response.setStreet1(employeeAddress.getStreet1());
        response.setStreet2(employeeAddress.getStreet2());
        response.setCity(employeeAddress.getCity());
        response.setState(employeeAddress.getState());
        response.setZipCode(employeeAddress.getZipCode());

        return response;
    }

    @JsonProperty("street_1") private String street1;
    @JsonProperty("street_2") private String street2;
    private String city;
    private String state;
    @JsonProperty("zip_code") private String zipCode;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
