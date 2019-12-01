package example.employee.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddress {

    public static EmployeeAddress from(ResultSet rs) throws SQLException {
        EmployeeAddress address = new EmployeeAddress();
        address.setId(rs.getLong("id"));
        address.setStreet1(rs.getString("street_1"));
        address.setStreet2(rs.getString("street_2"));
        address.setCity(rs.getString("city"));
        address.setState(rs.getString("state"));
        address.setZipCode(rs.getString("zip_code"));

        return address;
    }

    private long id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
