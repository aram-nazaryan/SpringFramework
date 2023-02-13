package com.example.cashbacksystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "USERS")
@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "USER_ID_GENERATOR",
            sequenceName = "USER_ID_GENERATOR_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_ID_GENERATOR"
    )
    private Long id;
    @Column(name = "UUID", updatable = false, nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();
    @Column(name = "USERNAME", nullable = false, unique = true, updatable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "REGISTERED_DATE", updatable = false, nullable = false)
    private LocalDateTime registeredAt;
    @LastModifiedDate
    @Column(name = "LAST_MODIFICATION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orders;
}
