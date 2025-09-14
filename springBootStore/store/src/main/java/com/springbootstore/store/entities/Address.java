package com.springbootstore.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private long id;
    @Column(nullable = false, name = "street")
    private String street;
    @Column(nullable = false, name = "city")
    private String city;
    @Column(nullable = false, name = "post_zip_code")
    private String postalZipCode;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
