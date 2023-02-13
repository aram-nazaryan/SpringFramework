package com.sourcemind.management.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @SequenceGenerator(
            name = "TAG_ID_GENERATOR",
            sequenceName = "TAG_ID_GENERATOR_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TAG_ID_GENERATOR"
    )
    private Long id;

    public Tag(String type) {
        this.type = type;
    }

    public Tag() {
    }

    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "prod_id",
            nullable = false
    )
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
