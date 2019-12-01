package example.employee.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id"
})
public class GetEmployeeResponse {

    private long id;
}
