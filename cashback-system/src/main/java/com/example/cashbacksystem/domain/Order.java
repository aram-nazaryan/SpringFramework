package com.example.cashbacksystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "ORDERS")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "ORDER_ID_GENERATOR",
            sequenceName = "ORDER_ID_GENERATOR_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_ID_GENERATOR"
    )
    private Long id;
    @Column(name = "AMOUNT", nullable = false, updatable = false)
    private BigDecimal paymentAmount;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(
            name = "USER_UUID",
            referencedColumnName = "uuid",
            updatable = false,
            nullable = false
    )
    private User user;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
