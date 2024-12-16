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

public class Influencer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer Influencer_id;

    @NotBlank(message = "Influencer name cannot be blank")
    @Size(min = 2, max = 100, message = "Influencer name must be between 2 and 100 characters")
    @Column(nullable = false)
    private String Influencer_name;

    @NotBlank(message = "Influencer phone cannot be blank")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be a valid format (e.g., +966234567890)")
    @Column(unique = true, nullable = false)
    private String Influencer_phone;

    @NotBlank(message = "Influencer email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private String Influencer_email;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    private List<Platform> platforms;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    private List<BookingOneTime> bookingOneTimes;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    private List<Package> packages;
}
