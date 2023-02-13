package com.sourcemind.management.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @SequenceGenerator(
            name = "PRODUCT_ID_GENERATOR",
            sequenceName = "PRODUCT_ID_GENERATOR_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRODUCT_ID_GENERATOR"
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;
    @Column(name = "imageBlobId", nullable = false, unique = true, updatable = false)
    private String imageBlobId = UUID.randomUUID().toString();
    @Column(name = "productOwnerUsername")
    private String username;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Tag> tagList;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "REGISTERED_DATE", updatable = false, nullable = false)
    private LocalDateTime registeredAt;
    @LastModifiedDate
    @Column(name = "LAST_MODIFICATION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBlobId() {
        return imageBlobId;
    }

    public void setImageBlobId(String imageBlobId) {
        this.imageBlobId = imageBlobId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
