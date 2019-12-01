package example.employee.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Employee {

    public static Employee from(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setLastName(rs.getString("last_name"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setHireDate(rs.getDate("hire_date"));
        employee.setDepartmentId(rs.getInt("department"));
        employee.setDepartmentName(rs.getString("department_name"));
        employee.setHomePhone(rs.getString("home_phone"));
        employee.setWorkPhone(rs.getString("work_phone"));
        employee.setHomeEmail(rs.getString("home_email"));
        employee.setWorkEmail(rs.getString("work_email"));
        employee.setHomeAddressId(rs.getLong("home_addr"));
        employee.setWorkAddressId(rs.getLong("work_addr"));
        employee.setSalary(rs.getDouble("salary"));

        return employee;
    }

    private long id;
    private String lastName;
    private String firstName;
    private Date hireDate;
    private int departmentId;
    private String departmentName;
    private String homePhone;
    private String workPhone;
    private String homeEmail;
    private String workEmail;
    private Long homeAddressId;
    private Long workAddressId;
    private double salary;

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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomeEmail() {
        return homeEmail;
    }

    public void setHomeEmail(String homeEmail) {
        this.homeEmail = homeEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public Long getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(Long homeAddressId) {
        this.homeAddressId = homeAddressId;
    }

    public Long getWorkAddressId() {
        return workAddressId;
    }

    public void setWorkAddressId(Long workAddressId) {
        this.workAddressId = workAddressId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
