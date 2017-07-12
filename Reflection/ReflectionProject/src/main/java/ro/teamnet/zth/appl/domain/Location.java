package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
@Table(name="LOCATIONS")
public class Location {
    @Id(name="LOCATION_ID")
    private Long id;
    @Column(name="STREET_ADDRESS")
    private String streetAddress;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE_PROVINCE")
    private String stateProvince;

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (!streetAddress.equals(location.streetAddress)) return false;
        if (!postalCode.equals(location.postalCode)) return false;
        if (!city.equals(location.city)) return false;
        return stateProvince.equals(location.stateProvince);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + streetAddress.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + stateProvince.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
