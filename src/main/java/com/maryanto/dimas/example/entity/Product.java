package com.maryanto.dimas.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@IdClass(ProductPrimaryKey.class)
public class Product {

    @Id
    @Column(name = "code")
    private String code;
    @Id
    @Column(name = "version")
    private String version;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "created_by")
    private String createdBy;
}
