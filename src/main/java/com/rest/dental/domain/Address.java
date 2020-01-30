package com.rest.dental.domain;

import lombok.Data;

@Data
public class Address {

    private String country;
    private String city;
    private String street;
    private String house;
    private Integer flat;

    public Address() {
    }

    public Address(String country, String city, String street, String house, Integer flat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}
