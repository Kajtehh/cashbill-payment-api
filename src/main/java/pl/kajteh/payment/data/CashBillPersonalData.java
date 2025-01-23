package pl.kajteh.payment.data;

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

    public String getIp() {
        return this.ip;
    }

    public CashBillPersonalData setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getFlat() {
        return this.flat;
    }

    public CashBillPersonalData setFlat(String flat) {
        this.flat = flat;
        return this;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public CashBillPersonalData setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getStreet() {
        return this.street;
    }

    public CashBillPersonalData setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHouse() {
        return this.house;
    }

    public CashBillPersonalData setHouse(String house) {
        this.house = house;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public CashBillPersonalData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return this.country;
    }

    public CashBillPersonalData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public CashBillPersonalData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public CashBillPersonalData setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public CashBillPersonalData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
