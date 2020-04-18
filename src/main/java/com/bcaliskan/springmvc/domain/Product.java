package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String description, imageUrl;
    private BigDecimal price;

}
