package com.kingwoodart.entity;

import com.kingwoodart.validation_group.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(groups = ValidationGroups.Update.class)
    @Column(length = 25, nullable = false)
    private String firstName;

    @NotNull(groups = ValidationGroups.Create.class)
    @Column(length = 25, nullable = false)
    private String lastName;

    @NotNull(groups = ValidationGroups.Update.class)
    @Column(unique = true)
    private String username;

    @NotNull(groups = ValidationGroups.Create.class)
    @Column(unique = true, nullable = false, length = 128)
    @Email
    private String email;

    @Column(unique = true)
    @NotNull(groups = ValidationGroups.Update.class)
    private String phoneNumber;

    @NotNull(groups = ValidationGroups.Update.class)
    private String city;

    @NotNull(groups = ValidationGroups.Update.class)
    @Column(length = 64, nullable = false)
    private String password;
    // TODO: add two fields of password and check them

    @CreationTimestamp
    private Date contCreated;

    @ManyToMany
    @JoinTable (
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public User(String firstName, String lastName, String username, String email, String phoneNumber, String city, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", contCreated=" + contCreated +
                '}';
    }
}
