package com.springbootstore.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    @Builder.Default
    private Profile profile = new Profile();

    @ManyToMany(mappedBy = "users")
    @Builder.Default
    private Set<Tag> tags = new LinkedHashSet<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setUser(this);
    }
    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setUser(null);
    }
}
