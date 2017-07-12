package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
@Table(name="DEPARTMENTS")
public class Department {
    @Id(name="DEPARTMNET_ID")
    private Long id;
    @Column(name="DEPARTMENT_NAME")
    private String departmentName;
    @Column(name="LOCATION_ID")
    private Location location;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {

        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", location=" + location +
                '}';
    }
}
