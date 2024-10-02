package org.acme.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.acme.constants.UserStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users", schema = "ecommerce")
public class UserDetails extends PanacheEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false, length = 20)
    private String phoneNumber;
    private String passwordHash;
    private String profilePictureUrl;
    private final boolean emailVerified = false;
    private final boolean phoneVerified = false;
    @Enumerated(EnumType.STRING)
    public UserStatus status;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;
    @OneToMany(targetEntity = Address.class, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "users")
    private List<Address> addressList;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
