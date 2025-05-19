package com.bookmydoctor.BookMyDoctor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false)
    @NotBlank(message = "enter your valid name")
    private String userName;

    @Column(nullable = false)
    @NotBlank(message = "enter your gender")
    private String gender;

    @Column(nullable = false)
    @NotNull(message = "enter your present age")
    @Min(0)
    private int age;

    @Column(nullable = false)
    @Email(message = "enter a valid email")
    @NotBlank(message = "email can't be blank")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "enter your password")
    private String password;

    @Column(nullable = false)
    @NotNull(message = "enter your valid phone number")
    private long phoneNo;

    @Column(nullable = false)
    @NotBlank(message = "enter your role")
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Appointment> appointmentList;


}
