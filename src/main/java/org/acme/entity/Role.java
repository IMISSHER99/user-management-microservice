package org.acme.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "role", schema = "ecommerce")
public class Role extends PanacheEntity {
    @Column(unique = true, nullable = false)
    private String roleName;
    @CreationTimestamp
    private LocalDateTime assignedAt;
    @ManyToMany(mappedBy = "roles")
    private List<UserDetails> users;
}
