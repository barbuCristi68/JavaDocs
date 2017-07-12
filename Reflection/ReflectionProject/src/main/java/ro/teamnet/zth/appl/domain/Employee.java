package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
@Table(name="EMPLOYEES")
public class Employee {
    @Id(name="EMPLOYEE_ID")
    private Long employeeId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE_NUMBER")
    private Long phoneNumber;
    @Column(name="HIRE_DATE")
    private Date hireDate;
    @Column(name="JOB_ID")
    private Long jobId;
    @Column(name="SALARY")
    private Long salary;
    @Column(name="COMMISSION_PCT")
    private Long commissionPct;
    @Column(name="MANAGER_ID")
    private Long managerId;
    @Column(name="DEPARTMENT_ID")
    private long departmentId;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", hireDate=" + hireDate +
                ", jobId=" + jobId +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (departmentId != employee.departmentId) return false;
        if (!employeeId.equals(employee.employeeId)) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        if (!phoneNumber.equals(employee.phoneNumber)) return false;
        if (!hireDate.equals(employee.hireDate)) return false;
        if (!jobId.equals(employee.jobId)) return false;
        if (!salary.equals(employee.salary)) return false;
        if (!commissionPct.equals(employee.commissionPct)) return false;
        return managerId.equals(employee.managerId);
    }

    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + jobId.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + commissionPct.hashCode();
        result = 31 * result + managerId.hashCode();
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        return result;
    }

    public void setEmployeeId(Long employeeId) {

        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setCommissionPct(Long commissionPct) {
        this.commissionPct = commissionPct;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {

        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Long getJobId() {
        return jobId;
    }

    public Long getSalary() {
        return salary;
    }

    public Long getCommissionPct() {
        return commissionPct;
    }

    public Long getManagerId() {
        return managerId;
    }

    public long getDepartmentId() {
        return departmentId;
    }
}
