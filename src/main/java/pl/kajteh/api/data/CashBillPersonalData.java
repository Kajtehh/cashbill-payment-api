package pl.kajteh.api.data;

import lombok.Getter;

@Getter
public class CashBillPersonalData {
    private String firstName;
    private String surname;
    private String email;
    private String country;
    private String city;
    private String postcode;
    private String street;
    private String house;
    private String flat;
    private String ip;

    public CashBillPersonalData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CashBillPersonalData setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CashBillPersonalData setEmail(String email) {
        this.email = email;
        return this;
    }

    public CashBillPersonalData setCountry(String country) {
        this.country = country;
        return this;
    }

    public CashBillPersonalData setCity(String city) {
        this.city = city;
        return this;
    }

    public CashBillPersonalData setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public CashBillPersonalData setStreet(String street) {
        this.street = street;
        return this;
    }

    public CashBillPersonalData setHouse(String house) {
        this.house = house;
        return this;
    }

    public CashBillPersonalData setFlat(String flat) {
        this.flat = flat;
        return this;
    }

    public CashBillPersonalData setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
