package com.mrp_engine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BomLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Item parentItem;

    @ManyToOne
    private Item childItem;

    private Integer quantityRequired;

}
