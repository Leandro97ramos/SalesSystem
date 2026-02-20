package com.icubexs.SalesSystem.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
        private Long locationId;
        private String name;
        private String address;
        private String city;
        private String state;
        private String postalCode;
        private String country;

}
