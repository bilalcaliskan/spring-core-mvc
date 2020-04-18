package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String firstName, lastName, email, phoneNumber, addressLine1, addressLine2, city, state, zipCode;

}
