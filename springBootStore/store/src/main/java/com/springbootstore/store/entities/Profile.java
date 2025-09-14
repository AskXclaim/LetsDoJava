package com.springbootstore.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;
    @Column(name = "bio")
    private String bio;
    @Column(name = "phone_number")
    private String phone;
    @Column(nullable = false, name = "date_of_birth")
    private Date birthDate;
    @Column(name = "loyalty_points")
    private int loyaltyPoints;

    @OneToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}
