package org.acme.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "address", schema = "ecommerce")
public class Address extends PanacheEntity {

    @ManyToOne(targetEntity = UserDetails.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
    @JoinColumn(name = "user_id")
    private UserDetails users;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private boolean isPrimary = false;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
}
