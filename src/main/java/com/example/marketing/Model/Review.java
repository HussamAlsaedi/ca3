package com.example.marketing.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer review_id;

    @NotEmpty(message = "Review description is mandatory")
    @Size(min = 10, max = 500, message = "Review description must be between 10 and 500 characters")
    @Column(nullable = false)
    private String review_description;

    @NotNull(message = "Review rating is mandatory")
    @Min(value = 1, message = "Review rating must be at least 1")
    @Max(value = 5, message = "Review rating cannot be more than 5")
    @Column(nullable = false)
    private Integer review_rating;

    @ManyToOne
    @JoinColumn(name = "Company_company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "Booking_booking_id", nullable = false)
    private BookingOneTime booking;
}
