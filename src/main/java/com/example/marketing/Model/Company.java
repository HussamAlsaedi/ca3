package com.example.marketing.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;

    @NotBlank(message = "Company name cannot be blank")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    @Column(nullable = false,length = 100)
    private String company_name;

    @NotBlank(message = "Company email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String company_email;

    @NotBlank(message = "Company phone number cannot be blank")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be a valid format (e.g., +1234567890)")
    @Column(nullable = false, unique = true)
    private String company_phone;

    @NotBlank(message = "Company CR cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9]{3,20}$", message = "Company CR must be alphanumeric and between 3 to 20 characters")
    @Column(nullable = false, unique = true)
    private String company_CR;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BookingOneTime> bookingOneTimes;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Review> reviews;


}
